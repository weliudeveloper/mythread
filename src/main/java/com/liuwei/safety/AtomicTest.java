package com.liuwei.safety;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wee
 * @Description:
 * @date 2020/6/4 10:22
 */
public class AtomicTest {

    private static int v = 0;

    public static void main(String[] args) {
//        AtomicInteger atomicInteger = new AtomicInteger();
        Lock lock = new ReentrantLock();
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    lock.lock();
                    v++;
                } finally {
                    lock.unlock();
                }
                System.out.println(Thread.currentThread().getName() + ": " + v);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    lock.lock();
                    v++;
                } finally {
                    lock.unlock();
                }
                System.out.println(Thread.currentThread().getName() + ": " + v);
            }
        }).start();
    }
}
