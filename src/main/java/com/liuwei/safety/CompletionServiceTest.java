package com.liuwei.safety;

import java.util.concurrent.*;

/**
 * @author wee
 * @Description:
 * @date 2020/6/16 11:51
 */
public class CompletionServiceTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test();
    }

    private static void test() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newCachedThreadPool();
        ExecutorCompletionService service = new ExecutorCompletionService(executor);
        Future<String> submit = service.submit(() -> {
            return "10";
        });
        Future<String> take = service.take();

        System.out.println(take.get());
    }
}
