package com.liuwei.hutool;

import java.util.Iterator;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author wee
 * @Description:
 * @date 2020/12/18 14:47
 */
public class Test {
    public static void main(String[] args) {
        Cat tom = new Cat("Tom", 20);
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new Runnable() {
            @Override
            public void run() {
                tom.eat();
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                Cat.run();
            }
        });

        service.shutdown();
    }
}
