package com.liuwei.safety.mode.bridge;

/**
 * @author wee
 * @Description:
 * @date 2020/10/14 14:36
 */
public abstract class Phone {
    Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    public void open() {
        this.brand.open();
    }

    public void close() {
        this.brand.close();
    }

    public void call() {
        this.brand.call();
    }
}
