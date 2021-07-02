package com.liuwei.safety;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * @author wee
 * @Description:
 * @date 2020/6/8 14:53
 */
public class RecursiveTaskTest {

    private static final int MAX = 3;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> submit = pool.submit(new MyRecursiveTask(0, 10));
        Integer result = submit.get();
        System.out.println(result);
    }


    private static class MyRecursiveTask extends RecursiveTask<Integer> {

        private final int start;
        private final int end;

        MyRecursiveTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if ((end - start) <= RecursiveTaskTest.MAX) {
                return IntStream.rangeClosed(start, end).sum();
            } else {
                int middle = (start + end) / 2;
                MyRecursiveTask left = new MyRecursiveTask(start, middle);
                MyRecursiveTask right = new MyRecursiveTask(middle + 1, end);
                left.fork();
                right.fork();
                return left.join() + right.join();
            }
        }
    }
}
