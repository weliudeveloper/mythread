package com.liuwei.safety.mode.observer;

/**
 * @author wee
 * @Description: 观察者
 * @date 2020/4/15 9:39
 */
public abstract class Observer {

    public Observer(Subject subject) {
        this.subject = subject;
    }

    protected Subject subject;

    public abstract void update();
}
