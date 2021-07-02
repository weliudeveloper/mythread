package com.liuwei.safety;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * @author wee
 * @Description:
 * @date 2020/6/12 11:35
 */
public class StrategyTest {

    public static void main(String[] args) throws InterruptedException {
//        testAbortPolicy();
//        testDiscardPolicy();
//        testDiscardOldestPolicy();
        testCallerRunsPolicy();

    }

    private static void testAbortPolicy() throws InterruptedException {
        /**
         * int corePoolSize,
         * int maximumPoolSize,
         * long keepAliveTime,
         * TimeUnit unit,
         * BlockingQueue<Runnable> workQueue,
         * ThreadFactory threadFactory,
         * RejectedExecutionHandler handler
         */

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 2,
                TimeUnit.SECONDS, new ArrayBlockingQueue(1),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        IntStream.rangeClosed(1, 4).boxed().forEach(i -> executor.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + " is doing ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        executor.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " the others do ");
        });

        TimeUnit.SECONDS.sleep(10);

        System.out.println(" i done....");
    }

    private static void testDiscardPolicy() throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2,
                2, TimeUnit.SECONDS,
                new ArrayBlockingQueue(1),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        IntStream.rangeClosed(1, 4).boxed().forEach(i -> executor.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + " is doing");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        executor.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " the others do ");
        });

        TimeUnit.SECONDS.sleep(10);

        System.out.println(" i done....");
    }

    private static void testDiscardOldestPolicy() throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2,
                2, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        IntStream.rangeClosed(1, 4).boxed().forEach(i -> executor.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " is doing");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        executor.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " the others do ");
        });

        TimeUnit.SECONDS.sleep(10);

        System.out.println(" i done....");
    }

    private static void testCallerRunsPolicy() throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2,
                2, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        IntStream.rangeClosed(1, 5).boxed().forEach(i -> executor.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " is doing");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        executor.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " the others do ");
        });

        TimeUnit.SECONDS.sleep(10);

        System.out.println(" i done....");
    }
}
