package com.liuwei.safety.mode.decorator;

/**
 * @author wee
 * @Description:
 * @date 2020/4/14 17:22
 */
public class ManDecoratorB extends Decorator {
    public void eat() {
        super.eat();
        System.out.println("===============");
        System.out.println("ManDecoratorB类");
    }
}
