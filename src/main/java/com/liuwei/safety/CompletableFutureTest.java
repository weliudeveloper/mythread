package com.liuwei.safety;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author wee
 * @Description:
 * @date 2020/6/16 17:25
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        CompletableFuture<String> completableFuture = testCompletedFuture();
//        String value = future.get();
//        System.out.println(value);
//        completableFuture.whenCompleteAsync((v,t)-> System.out.println("=== done ==="));
//        completableFuture.whenComplete((v,t)->System.out.println("== done =="));
//        CompletableFuture<Object> completableFuture = testAnyOf();
        testThenAcceptBoth();
        Thread.currentThread().join();
    }

    private static void testThenAcceptBoth() {
        CompletableFuture.supplyAsync(() -> {
            return "10";
        }).thenAcceptBoth(CompletableFuture.supplyAsync(() -> {
            return 30;
        }), (s, v) -> System.out.println(s));
    }

    private static CompletableFuture<String> testCompletedFuture() {
        return CompletableFuture.completedFuture("i am doing ..");
    }

    private static CompletableFuture<Object> testAnyOf() {
        return CompletableFuture.anyOf(CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("the one do..");
        }), CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("the two do..");
        }));
    }
}
