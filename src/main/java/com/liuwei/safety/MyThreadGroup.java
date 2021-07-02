package com.liuwei.safety;

import java.util.Arrays;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wee
 * @date 2020.04.11
 */
public class MyThreadGroup {

    public static void main(String[] args) {

        /**
         * 相当于做进程被kill的时候的通知
         */
//        Runtime.getRuntime().addShutdownHook(new Thread());
        ThreadGroup threadGroup = new ThreadGroup("threadGroup");

        Thread thread = new Thread(threadGroup, "t1") {
            @Override
            public void run() {
                println("我是" + Thread.currentThread().getName());
                try {
                    Thread.sleep(10);
                    interrupt();
                } catch (Exception e) {
                    println("我捕获到了哦");
                }
            }
        };

        thread.start();
        threadGroup.interrupt();
//        threadGroup.setDaemon(true);

    }

    private static <T> void println(T target) {
        System.out.println(target);
    }

    private static void print(Object target) {
        System.out.println(target);
    }
}
