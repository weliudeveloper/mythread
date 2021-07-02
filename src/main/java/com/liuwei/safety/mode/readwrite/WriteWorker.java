package com.liuwei.safety.mode.readwrite;

/**
 * @author wee
 * @Description:
 * @date 2020/4/19 20:51
 */
public class WriteWorker extends Thread {

    private final SharedData sharedData;
    private String value;

    public WriteWorker(SharedData sharedData, String value) {
        this.sharedData = sharedData;
        this.value = value;
    }

    @Override
    public void run() {
        try {
            while (true) {
                sharedData.write(value);
                Thread.sleep(3_00);
            }
        } catch (InterruptedException e) {

        }
    }
}
