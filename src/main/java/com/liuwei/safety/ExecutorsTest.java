package com.liuwei.safety;

import java.io.InputStream;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author wee
 * @Description:
 * @date 2020/6/10 16:03
 */
public class ExecutorsTest {

    public static void main(String[] args) throws InterruptedException {
//        useFixedPoolExecutor();
//        System.out.println(Runtime.getRuntime().availableProcessors());
        /*ExecutorService executor = useWorkStealExecutor();

        List<Callable<String>> collectList = IntStream.rangeClosed(1, 20).boxed().map(i -> (Callable<String>) () -> {
            System.out.println(Thread.currentThread().getName() + " do working..");
            TimeUnit.SECONDS.sleep(5);
            return "Task --" + i;
        }).collect(Collectors.toList());

        executor.invokeAll(collectList);*/
    }

    static void useCachePoolExecutor() throws InterruptedException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        IntStream.rangeClosed(1, 10).boxed().forEach(i -> executor.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " do working ");
        }));

        System.out.println("getQueue->" + executor.getQueue());
        System.out.println("getActiveCount->" + executor.getActiveCount());
        System.out.println("getCompletedTaskCount->" + executor.getCompletedTaskCount());
        System.out.println("getCorePoolSize->" + executor.getCorePoolSize());
        System.out.println("getPoolSize->" + executor.getPoolSize());
        TimeUnit.SECONDS.sleep(61);
        System.out.println("getCorePoolSize->" + executor.getCorePoolSize());
        System.out.println("getPoolSize->" + executor.getPoolSize());
    }

    static void useFixedPoolExecutor() {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

        IntStream.rangeClosed(1, 10).boxed().forEach(i -> executor.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " do working ");
        }));

        System.out.println("getQueue->" + executor.getQueue());
        System.out.println("getActiveCount->" + executor.getActiveCount());
        System.out.println("getCompletedTaskCount->" + executor.getCompletedTaskCount());
        System.out.println("getCorePoolSize->" + executor.getCorePoolSize());
        System.out.println("getPoolSize->" + executor.getPoolSize());
    }

    static void useSinglePoolExecutor() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

    }

    static ExecutorService useWorkStealExecutor() {
        ExecutorService executorService = Executors.newWorkStealingPool();

        return executorService;
    }
}
