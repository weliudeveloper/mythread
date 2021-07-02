package com.liuwei.javaguide.basis;

import java.io.*;

/**
 * @author wee
 * @Description:
 * @date 2020/4/11 22:58
 */
public class IoTest {

    public static void main(String[] args) {
        File file = new File("D:/wjgapt_log4j.log");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            int len = 0;
            byte[] size = new byte[1024];
            while ((len = fileInputStream.read(size)) != -1) {
                System.out.println(new String(size, 0, len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*try {
            FileOutputStream fileOutputStream = new FileOutputStream(file,true);
            byte[] len = new byte[1024];
            fileOutputStream.write("hello".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }
}
