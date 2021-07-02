package com.liuwei.safety.mode;

/**
 * @author wee
 * @Description:
 * @date 2020/4/12 15:32
 */
public class VolatileTest {

    /**
     * volatile 可以保证可读性和有序性
     */
    private static volatile int init_value = 0;

    private static int max_value = 5;

    public static void main(String[] args) {
        new Thread("read") {
            @Override
            public void run() {
                int localValue = init_value;
                while (localValue < max_value) {
                    if (localValue != init_value) {
                        System.out.println("the value is read " + localValue);
                        localValue = init_value;
                    }
                }
            }
        }.start();

        new Thread("write") {
            @Override
            public void run() {
                int localValue = init_value;
                while (init_value < max_value) {
                    System.out.println("the value is update " + (localValue++));
                    init_value = localValue;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
