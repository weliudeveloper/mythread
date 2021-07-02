package com.liuwei.safety;

import java.util.Arrays;
import java.util.List;

/**
 * @author wee
 * @Description:
 * @date 2020/4/19 11:22
 */
public class ThreadObserverImpl implements ThreadObserver {

    private final Object LOCK = new Object();

    public void query(List<String> ids) {
        if (ids.isEmpty())
            return;
        ids.forEach(id -> new Thread(new ThreadSubject(this) {
            @Override
            public void run() {
                try {
                    notifyChange(new RunnableEvent(SubjectState.RUNNING, null, Thread.currentThread()));
                    System.out.println("query for " + id);
                    Thread.sleep(1_000);
                    notifyChange(new RunnableEvent(SubjectState.DONE, null, Thread.currentThread()));
                } catch (Exception e) {
                    notifyChange(new RunnableEvent(SubjectState.ERROR, null, Thread.currentThread()));
                }
            }
        }, id).start());
    }

    @Override
    public void onEvent(ThreadSubject.RunnableEvent event) {
        synchronized (LOCK) {//引起数据不一致
            System.out.println("the runnable " + event.getThread().getName() + " data changed " + event.getState());
        }
    }

    public static void main(String[] args) {
        new ThreadObserverImpl().query(Arrays.asList("1", "2"));
    }
}
