package com.liuwei.safety.mode.readwrite;

/**
 * @author wee
 * @Description:
 * @date 2020/4/19 20:51
 */
public class ReadWorker extends Thread {

    private final SharedData sharedData;

    public ReadWorker(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        try {
            while (true) {
                sharedData.read();
                Thread.sleep(5_00);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
