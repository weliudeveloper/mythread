package com.liuwei.safety;

/**
 * @author wee
 */
public class TickerThread extends Thread {

    /**
     * 票号
     */
    private int index = 1;

    private static final int TICKET_COUNT = 50;

    private String name;

    private Object object = new Object();

    public TickerThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (object) {
                if (index >= 50) {
                    break;
                }
                if (index < TICKET_COUNT) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("第" + name + ",叫号：" + index++);
                }
            }
        }
    }
}
