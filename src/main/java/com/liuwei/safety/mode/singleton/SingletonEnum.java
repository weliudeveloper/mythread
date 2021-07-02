package com.liuwei.safety.mode.singleton;

import java.util.stream.IntStream;

/**
 * @author wee
 * @Description: 使用枚举类创建单例模式
 * @date 2020/4/12 14:50
 */
public class SingletonEnum {

    private SingletonEnum() {

    }

    /**
     * 枚举类是线程安全的,并且只会实例化一次
     */
    private static enum Instance {
        INSTANCE;

        private static final SingletonEnum s = new SingletonEnum();

        public SingletonEnum createSingleton() {
            return s;
        }
    }

    public static SingletonEnum getInstance() {
        return Instance.INSTANCE.createSingleton();
    }

    public static void main(String[] args) {
        IntStream.range(1, 10).forEach(value ->
                System.out.println(SingletonEnum.getInstance())
        );
    }
}
