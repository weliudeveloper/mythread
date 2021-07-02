package com.liuwei.safety.mode.observer;

/**
 * @author wee
 * @Description: 具体观察者
 * @date 2020/4/15 9:47
 */
public class BinaryObServer extends Observer {

    public BinaryObServer(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println(Integer.toBinaryString(subject.getState()));
    }
}
