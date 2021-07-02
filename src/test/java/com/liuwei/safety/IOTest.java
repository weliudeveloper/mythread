package com.liuwei.safety;

import org.apache.log4j.net.SocketServer;
import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @author wee
 * @Description:
 * @date 2020/7/24 15:50
 */
public class IOTest {

    @Test
    public void ioTest() throws IOException {
        File file = new File("D:/key/西游记.txt");

        FileInputStream fileInputStream = new FileInputStream(file);

        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }

        FileOutputStream fileOutputStream = new FileOutputStream(file, true);

        fileOutputStream.write("白骨夫人".getBytes());
    }

}
