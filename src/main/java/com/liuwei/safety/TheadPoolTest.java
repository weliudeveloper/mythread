package com.liuwei.safety;

import java.io.InputStream;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * @author wee
 * @Description:
 * @date 2020/6/10 13:47
 */
public class TheadPoolTest {

    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue queue = new ArrayBlockingQueue(2);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 2,
                TimeUnit.SECONDS, queue, r -> {
            Thread thread = new Thread(r);
            return thread;
        }, new ThreadPoolExecutor.AbortPolicy());

       /* for (int i = 1; i < 6; i++) {
            executor.execute(()->{
                System.out.println("the number" + Thread.currentThread().getName() + " is working");
            });
            System.out.println("getCompletedTaskCount->" + executor.getCompletedTaskCount());
        }

        System.out.println("getCompletedTaskCount->" + executor.getCompletedTaskCount());

        System.out.println("getActiveCount->" + executor.getActiveCount());

        System.out.println("getTaskCount->" + executor.getTaskCount());


        TimeUnit.SECONDS.sleep(3);

        executor.shutdown();*/
        IntStream.rangeClosed(1, 7).boxed().forEach(i -> executor.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " do working..");
        }));
    }
}
