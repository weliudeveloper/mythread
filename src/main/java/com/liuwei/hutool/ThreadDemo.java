package com.liuwei.hutool;

import java.util.concurrent.TimeUnit;

/**
 * @author wee
 * @Description:
 * @date 2021/1/27 10:13
 */
public class ThreadDemo implements Runnable {
    public boolean isFlag = false;

    public boolean getFlag() {
        return isFlag;
    }

    public void setFlag(boolean flag) {
        isFlag = flag;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(3);
            setFlag(true);
            System.out.println("设置了isFlag: =====" + getFlag());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
