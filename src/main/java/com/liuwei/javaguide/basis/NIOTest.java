package com.liuwei.javaguide.basis;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author wee
 * @Description:
 * @date 2020/4/16 11:25
 */
public class NIOTest {

    public static void main(String[] args) throws IOException {

        new Thread() {
            @Override
            public void run() {
                try {
                    //通道
                    DatagramChannel datagramChannel = DatagramChannel.open();

                    //设置成为非阻塞
                    datagramChannel.configureBlocking(false);

                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                    Scanner scanner = new Scanner(System.in);

                    while (scanner.hasNext()) {
                        String value = scanner.next();
                        byteBuffer.put(value.getBytes());
                        byteBuffer.flip();
                        datagramChannel.send(byteBuffer, new InetSocketAddress("127.0.0.1", 3333));
                        byteBuffer.clear();
                    }
                    datagramChannel.close();
                } catch (Exception e) {

                }
            }
        }.start();


        new Thread(() -> {
            try {
                //获取通道
                DatagramChannel datagramChannel = DatagramChannel.open();
                //设置为非阻塞
                datagramChannel.configureBlocking(false);
                //绑定端口
                datagramChannel.bind(new InetSocketAddress(3333));

                //复用选择器
                Selector selector = Selector.open();
                //在通道中注册复用选择器
                datagramChannel.register(selector, SelectionKey.OP_READ);

                while (selector.select() > 0) {

                    //拿出复用选择器中的复选key
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

                    while (iterator.hasNext()) {
                        SelectionKey sk = iterator.next();
                        //判断是否为可读
                        if (sk.isReadable()) {
                            //创建一个byte缓冲区
                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            //通道接收缓冲区
                            datagramChannel.receive(byteBuffer);
                            byteBuffer.flip();
                            System.out.println(new String(byteBuffer.array(), 0, byteBuffer.limit()));
                            byteBuffer.clear();
                        }
                    }

                    iterator.remove();
                }
                datagramChannel.close();
            } catch (Exception e) {
            }
        }).start();
    }


    private static void threadNio() {
        //A.客户端
        //创建多个线程，模拟多个客户端连接服务端
        new Thread() {
            @Override
            public void run() {
                try {
                    Socket socket = new Socket("127.0.0.1", 3333);
                    while (true) {
                        try {
                            LocalDateTime now = LocalDateTime.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            String date = now.format(formatter);
                            socket.getOutputStream().write((date + " --- hello").getBytes());
                            Thread.sleep(2_000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        //B.服务器
        // 1. serverSelector负责轮询是否有新的连接，服务端监测到新的连接之后，不再创建一个新的线程，
        // 而是直接将新连接绑定到clientSelector上，这样就不用 IO 模型中 1w 个 while 循环在死等
        try {
            Selector serverSelector = Selector.open();
            // 2. clientSelector负责轮询连接是否有数据可读
            Selector clientSelector = Selector.open();
            new Thread() {
                @Override
                public void run() {
                    try {
                        // 对应IO编程中服务端启动
                        ServerSocketChannel listenerChannel = ServerSocketChannel.open();
                        listenerChannel.socket().bind(new InetSocketAddress(3333));
                        listenerChannel.configureBlocking(false);
                        listenerChannel.register(serverSelector, SelectionKey.OP_ACCEPT);

                        while (true) {
                            // 监测是否有新的连接，这里的1指的是阻塞的时间为 1ms
                            if (serverSelector.select(1) > 0) {
                                Set<SelectionKey> set = serverSelector.selectedKeys();
                                Iterator<SelectionKey> keyIterator = set.iterator();

                                while (keyIterator.hasNext()) {
                                    SelectionKey key = keyIterator.next();

                                    if (key.isAcceptable()) {
                                        try {
                                            // (1) 每来一个新连接，不需要创建一个线程，而是直接注册到clientSelector
                                            SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept();
                                            clientChannel.configureBlocking(false);
                                            clientChannel.register(clientSelector, SelectionKey.OP_READ);
                                        } finally {
                                            keyIterator.remove();
                                        }
                                    }

                                }
                            }
                        }
                    } catch (IOException ignored) {
                    }
                }
            }.start();

            new Thread(() -> {
                try {
                    while (true) {
                        // (2) 批量轮询是否有哪些连接有数据可读，这里的1指的是阻塞的时间为 1ms
                        if (clientSelector.select(1) > 0) {
                            Set<SelectionKey> set = clientSelector.selectedKeys();
                            Iterator<SelectionKey> keyIterator = set.iterator();

                            while (keyIterator.hasNext()) {
                                SelectionKey key = keyIterator.next();

                                if (key.isReadable()) {
                                    try {
                                        SocketChannel clientChannel = (SocketChannel) key.channel();
                                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                        // (3) 面向 Buffer
                                        clientChannel.read(byteBuffer);
                                        byteBuffer.flip();
                                        System.out.println(
                                                Charset.defaultCharset().newDecoder().decode(byteBuffer).toString());
                                    } finally {
                                        keyIterator.remove();
                                        key.interestOps(SelectionKey.OP_READ);
                                    }
                                }

                            }
                        }
                    }
                } catch (IOException ignored) {
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
