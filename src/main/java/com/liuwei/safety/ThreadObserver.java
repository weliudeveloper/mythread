package com.liuwei.safety;

/**
 * @author wee
 * @Description: 观察者
 * @date 2020/4/19 11:04
 */
public interface ThreadObserver {

    void onEvent(ThreadSubject.RunnableEvent event);
}
