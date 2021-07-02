package com.liuwei.safety;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author wee
 * @Description:
 * @date 2020/6/4 11:42
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Long begin = System.currentTimeMillis();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " do something...");
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " prepare data for other thread");
            try {
                Thread.sleep(10_000);
                System.out.println("我没有被执行");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Long end = System.currentTimeMillis();

        System.out.println(end - begin);

        System.out.println("main 线程执行完了哦");
    }
}
