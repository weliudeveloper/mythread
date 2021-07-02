package com.liuwei.safety;

import java.util.concurrent.*;

/**
 * @author wee
 * @Description:
 * @date 2020/6/16 10:08
 */
public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        testGet();
    }

    /**
     * {@link Future#get()}
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void testGet() throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                return thread;
            }
        });
        Future<Integer> future = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("===========");
            return 10;
        });

//        future.cancel(true);

//        Thread.currentThread().interrupt();
        Integer value = future.get(2, TimeUnit.SECONDS);
        System.out.println(value);

    }
}
