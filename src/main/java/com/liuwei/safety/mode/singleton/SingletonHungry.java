package com.liuwei.safety.mode.singleton;

/**
 * @author wee
 * @Description: 饿汉式创建单例模式
 */
public class SingletonHungry {


    /**
     * 1.目的是防止外部创建
     */
    private SingletonHungry() {

    }

    /**
     * 2.构建该对象--所以外部都是引用的同一个该对象
     */
    private static class CreateSingleton {
        private static final SingletonHungry SINGLETON = new SingletonHungry();
    }


    /**
     * 3.目的是让外部可以获取该对象
     *
     * @return
     */
    public static SingletonHungry getSingleton() {
        return CreateSingleton.SINGLETON;
    }


}
