package com.liuwei.javaguide.basis;

import java.util.concurrent.Exchanger;

/**
 * @author wee
 * @Description:
 * @date 2020/6/5 11:54
 */
public class ExchangerTest {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(() -> {
            try {
                String result = exchanger.exchange(" A do something");
                System.out.println(Thread.currentThread().getName() + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                String result = exchanger.exchange(" B do something");
                System.out.println(Thread.currentThread().getName() + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
