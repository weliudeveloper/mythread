package com.liuwei.safety;

/**
 * @author wee
 */
public class Ticket implements Runnable {

    /**
     * 票号
     */
    private int order = 1;

    private final int TICKET_COUNT = 500;

    private final Object object = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (object) {
                if (order >= TICKET_COUNT) {
                    break;
                }
                if (order < TICKET_COUNT) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("第" + Thread.currentThread().getName() + ",叫号：" + order++);
                }
            }
        }
    }
}
