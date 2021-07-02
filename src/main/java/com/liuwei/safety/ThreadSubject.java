package com.liuwei.safety;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wee
 * @Description: 目标
 * @date 2020/4/19 11:03
 */
public abstract class ThreadSubject implements Runnable {

    protected ThreadObserver observer;

    public ThreadSubject(ThreadObserver observer) {
        this.observer = observer;

    }

    public void notifyChange(RunnableEvent event) {
        observer.onEvent(event);
    }

    public enum SubjectState {
        RUNNING, ERROR, DONE;
    }

    public static class RunnableEvent {
        private SubjectState state;
        private Throwable throwable;
        private Thread thread;//观察的是这个线程

        public RunnableEvent(SubjectState state, Throwable throwable, Thread thread) {
            this.state = state;
            this.throwable = throwable;
            this.thread = thread;
        }

        public SubjectState getState() {
            return state;
        }

        public Throwable getThrowable() {
            return throwable;
        }

        public Thread getThread() {
            return thread;
        }
    }


}
