package com.liuwei.safety.mode.singleton;

import java.util.stream.IntStream;

/**
 * @author wee
 * @Description: 懒汉式单例模式
 * @date 2020/4/12 15:02
 */
public class SingletonLazy {

    /**
     * 加volatile目的是为了防止SingletonLazy在初始化的时候里面的变量太多，
     * 以至于其他地方调用出现空指针，volatile--可以确保SingletonLazy初始化完成才能被调用
     */
    private static volatile SingletonLazy singletonLazy;

    private SingletonLazy() {

    }

    /**
     * 加synchronized目的是为了防止多线程情况下同时创建单例
     *
     * @return
     */
    public static SingletonLazy getInstance() {

        if (singletonLazy == null) {
            synchronized (SingletonLazy.class) {
                if (singletonLazy == null) {
                    singletonLazy = new SingletonLazy();
                }
            }
        }

        return singletonLazy;
    }

    public static void main(String[] args) {
        IntStream.range(1, 10).forEach(n ->
                System.out.println(SingletonLazy.getInstance())
        );
    }
}
