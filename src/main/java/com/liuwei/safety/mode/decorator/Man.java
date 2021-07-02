package com.liuwei.safety.mode.decorator;

/**
 * @author wee
 * @Description:
 * @date 2020/4/14 17:18
 */
public class Man implements Person {
    @Override
    public void eat() {
        System.out.println("男人再吃");
    }
}
