package com.liuwei.safety;

import java.util.concurrent.locks.Lock;
import java.util.stream.Stream;

/**
 * @author wee
 * @date 2020-04-09
 */
public class ProduceAndConsumer {

    /**
     * 产品
     */
    private int product = 0;

    private final Object LOCK = new Object();

    private volatile boolean isProduce = false;

    /**
     * 生产者用于生产数据供消费者使用
     */
    public void producer() {
        synchronized (LOCK) {
            while (isProduce) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            product++;
            System.out.println(Thread.currentThread().getName() + "生产了一个产品" + product);
            LOCK.notifyAll();
            isProduce = true;
        }
    }

    /**
     * 消费者用于消费生产者的数据
     */
    public void consumer() {
        synchronized (LOCK) {
            while (!isProduce) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "消费了一个产品" + product);
            LOCK.notifyAll();
            isProduce = false;
        }
    }

    public static void main(String[] args) {
        final ProduceAndConsumer produceAndConsumer = new ProduceAndConsumer();
        Stream.of("p1", "p2").forEach(n ->
                new Thread(n) {
                    @Override
                    public void run() {
                        while (true) {
                            produceAndConsumer.producer();
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start());

        Stream.of("c1", "c2").forEach(n ->
                new Thread(n) {
                    @Override
                    public void run() {
                        while (true) {
                            produceAndConsumer.consumer();
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start());
    }
}
