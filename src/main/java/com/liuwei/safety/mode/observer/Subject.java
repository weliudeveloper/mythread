package com.liuwei.safety.mode.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author wee
 * @Description: 目标
 * @date 2020/4/15 9:37
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void add(Observer observer) {
        observers.add(observer);
    }

    public void setState(int state) {
        if (this.state == state) {
            return;
        }
        this.state = state;
        notifyObserver();
    }

    private void notifyObserver() {
        observers.stream().forEach(Observer::update);
    }

    public static void main(String[] args) {
        Subject subject = new Subject();
        BinaryObServer binaryObServer = new BinaryObServer(subject);
        subject.add(binaryObServer);
        subject.setState(10);
        System.out.println("============");
        subject.setState(10);
        System.out.println("============");
        subject.setState(20);
    }
}
