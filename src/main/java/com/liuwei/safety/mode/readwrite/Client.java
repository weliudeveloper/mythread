package com.liuwei.safety.mode.readwrite;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wee
 * @Description:
 * @date 2020/4/19 20:57
 */
public class Client {

    public static void main(String[] args) {
        SharedData sharedData = new SharedData(10);
        new ReadWorker(sharedData).start();
        new ReadWorker(sharedData).start();
        new ReadWorker(sharedData).start();
        new ReadWorker(sharedData).start();
        new WriteWorker(sharedData, "qwer").start();
        new WriteWorker(sharedData, "QWER").start();

    }
}
