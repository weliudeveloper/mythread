package com.liuwei.safety;

/**
 * @author wee
 * @date 2020.04.09
 */
public class ProducerAndConsumerTest {

    public static void main(String[] args) {
        final ProduceAndConsumer produceAndConsumer = new ProduceAndConsumer();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    produceAndConsumer.producer();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                produceAndConsumer.consumer();
            }
        }.start();
    }
}
