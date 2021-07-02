package com.liuwei.javaguide.basis;

/**
 * @author wee
 * @Description:
 * @date 2020/10/29 15:05
 */
public class Cat extends Animal {

    public void zls() {
        System.out.println("猫会抓老鼠");
    }

   /* @Override
    public void eat() {
        System.out.println("猫在吃饭");
    }*/

    @Override
    public void sleep() {
        System.out.println("猫在睡觉");
    }
}
