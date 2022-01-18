package com.liuwei.hutool;

import io.netty.channel.unix.DatagramSocketAddress;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author wee
 * @Description:
 * @date 2020/12/18 14:47
 */
public class TestNio {
    public static void main(String[] args) throws Exception {
        Pipe pipe = Pipe.open();

        Pipe.SinkChannel sink = pipe.sink();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        buffer.put("hello".getBytes());

        buffer.flip();

        sink.write(buffer);

        Pipe.SourceChannel source = pipe.source();

        buffer.flip();

        int len = source.read(buffer);

        System.out.println(new String(buffer.array(), 0 , len));

        sink.close();
        source.close();
    }
}
