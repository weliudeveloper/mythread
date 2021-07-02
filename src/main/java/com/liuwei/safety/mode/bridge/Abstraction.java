package com.liuwei.safety.mode.bridge;

/**
 * @author wee
 * @Description: 抽象化给出的定义，并保存一个对实现化对象的引用。
 * @date 2020/4/14 16:10
 */
public abstract class Abstraction {
    protected Implementor impl;

    public void setImpl(Implementor impl) {
        this.impl = impl;
    }

    public abstract void operation();
}
