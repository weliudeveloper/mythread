package com.liuwei.safety;

import java.util.concurrent.*;

/**
 * @author wee
 * @Description:
 * @date 2020/6/4 16:27
 */
public class CyclicBarrierTest {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("they done...");
            }
        });

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " do something");
            try {
                TimeUnit.SECONDS.sleep(30);
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " done..");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " do something");
            try {
                TimeUnit.SECONDS.sleep(20);
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " done..");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });


        System.out.println("我是main线程的东西");
    }
}
