package com.liuwei.safety;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author wee
 * @Description:
 * @date 2020/6/8 15:19
 */
public class RecursiveActionTest {

    private static final int MAX = 3;

    private static AtomicInteger sum = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(new MyRecursiveAction(0, 10));
        pool.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(sum);
    }

    private static class MyRecursiveAction extends RecursiveAction {

        private final int start;
        private final int end;

        MyRecursiveAction(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if ((end - start) <= RecursiveActionTest.MAX) {
                sum.addAndGet(IntStream.rangeClosed(start, end).sum());
            } else {
                int middle = (start + end) / 2;
                MyRecursiveAction left = new MyRecursiveAction(start, middle);
                MyRecursiveAction right = new MyRecursiveAction(middle + 1, end);
                left.fork();
                right.fork();
            }
        }
    }
}
