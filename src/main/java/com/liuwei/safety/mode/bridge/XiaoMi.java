package com.liuwei.safety.mode.bridge;

/**
 * @author wee
 * @Description:
 * @date 2020/10/14 14:35
 */
public class XiaoMi implements Brand {

    @Override
    public void open() {
        System.out.println(" XiaoMi手机开机");
    }

    @Override
    public void close() {
        System.out.println(" XiaoMi手机关机");
    }

    @Override
    public void call() {
        System.out.println(" XiaoMi手机打电话");
    }
}
