package com.liuwei.safety.mode.bridge;

/**
 * @author wee
 * @Description:
 * @date 2020/10/14 14:40
 */
public class ZdPhone extends Phone {

    public ZdPhone(Brand brand) {
        super(brand);
    }

    public void open() {
        super.open();
        System.out.println("折叠手机");
    }

    public void close() {
        super.close();
        System.out.println("折叠手机");
    }

    public void call() {
        super.call();
        System.out.println("折叠手机");
    }
}
