package com.liuwei.safety;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.concurrent.*;

/**
 * @author wee
 * @Description:
 * @date 2020/6/15 17:03
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        /*ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2 , 2,
                                                            TimeUnit.SECONDS, new ArrayBlockingQueue<>(1),
                                                            Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());*/


        ExecutorService executorService = Executors.newFixedThreadPool(1);

        /*executor.setKeepAliveTime(20, TimeUnit.SECONDS);
        executor.setMaximumPoolSize(2);*/

      /*  int i = executor.prestartAllCoreThreads();
        System.out.println(i);*/

        /*System.out.println(executor.getActiveCount());

        executor.prestartCoreThread();
        System.out.println(executor.getActiveCount());

        executor.prestartCoreThread();
        System.out.println(executor.getActiveCount());*/

    }


}
