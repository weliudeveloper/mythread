package com.liuwei.safety;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wee
 * @Description:
 * @date 2020/6/5 17:46
 */
public class LockTest {

    private static final ReentrantLock lock = new ReentrantLock(true);

    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private static final ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();

    private static final ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    private static List<Long> data = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            write();
        }).start();

        Thread.sleep(1000);

        new Thread(() -> {
            read();
        }).start();
    }

    private static void write() {
        try {
            writeLock.lock();
            data.add(System.currentTimeMillis());
            System.out.println(Thread.currentThread().getName() + " writing data");
        } finally {
            writeLock.unlock();
        }
    }

    private static void read() {
        try {
            readLock.lock();
            data.forEach(System.out::println);
        } finally {
            readLock.unlock();
        }
    }
}
