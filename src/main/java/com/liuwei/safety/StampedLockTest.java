package com.liuwei.safety;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * @author wee
 * @Description:
 * @date 2020/6/8 11:55
 */
public class StampedLockTest {

    private static StampedLock stampedLock = new StampedLock();

    private static List<Long> list = new ArrayList<>();

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                read();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                read();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                read();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                read();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                read();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                read();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                read();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                read();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                read();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                write();
            }
        }).start();
    }

    private static void read() {
        long stamp = -1;
        try {
            stamp = stampedLock.readLock();
            System.out.println("i do the read");
            list.forEach(System.out::println);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            stampedLock.unlockRead(stamp);
        }
    }

    private static void write() {
        long stamp = -1;
        try {
            stamp = stampedLock.writeLock();
            System.out.println("i do the write");
            list.add(System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }
}
