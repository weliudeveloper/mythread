package com.liuwei.hutool;

import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/**
 * @author wee
 * @Description:
 * @date 2020/12/18 14:48
 */
public class Cat implements Comparable<Cat> {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static synchronized void eat() {
        System.out.println("小猫咪在吃鱼。。。");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void sleep() {
        System.out.println("小猫咪在睡觉。。。");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void run() {
        System.out.println("小猫咪在运动。。。");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Cat o) {
        return this.name.compareTo(o.getName());
    }
}
