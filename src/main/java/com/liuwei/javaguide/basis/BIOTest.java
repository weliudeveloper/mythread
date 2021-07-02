package com.liuwei.javaguide.basis;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author wee
 * @Description:
 * @date 2020/4/16 10:32
 */
public class BIOTest {

    public static void main(String[] args) throws IOException {

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
                            Thread.sleep(3_000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        //用来接收客户端链接信息
        ServerSocket serverSocket = new ServerSocket(3333);
        // 接收到客户端连接请求之后为每个客户端创建一个新的线程进行链路处理
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        // 阻塞方法获取新的连接
                        Socket socket = serverSocket.accept();

                        int len;
                        byte[] data = new byte[1024];
                        InputStream inputStream = socket.getInputStream();
                        // 按字节流方式读取数据
                        while ((len = inputStream.read(data)) != -1) {
                            System.out.println(new String(data, 0, len));
                        }

                        // 每一个新的连接都创建一个线程，负责读取数据
                        /*new Thread(() -> {
                            try {
                                int len;
                                byte[] data = new byte[1024];
                                InputStream inputStream = socket.getInputStream();
                                // 按字节流方式读取数据
                                while ((len = inputStream.read(data)) != -1) {
                                    System.out.println(new String(data, 0, len));
                                }
                            } catch (IOException e) {
                            }
                        }).start();*/

                    } catch (IOException e) {
                    }
                }
            }
        }.start();
    }
}
