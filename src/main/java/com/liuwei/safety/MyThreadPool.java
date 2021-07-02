package com.liuwei.safety;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author wee
 * @Description:
 * @date 2020/4/11 17:49
 */
public class MyThreadPool {

    //工作多少
    private int size;
    //线程大小
    private static final int TREAD_SIZE = 10;
    //线程名字前缀
    private static final String THREAD_NAME = "thread";
    //线程名字后缀
    private static int seq = 0;
    //线程组队列
    private final ThreadGroup threadGroup = new ThreadGroup("pool");
    //工作队列
    private static final LinkedList<Runnable> WORK_QUEUE = new LinkedList();
    //实际工作队列
    private static final List<Worker> TASK_QUEUE = new ArrayList<Worker>();

    //给默认线程大小
    public MyThreadPool() {
        this(TREAD_SIZE);
    }

    public MyThreadPool(int size) {
        this.size = size;
        init();
    }


    //初始化--根据外面传来的size大小创建工作
    private void init() {
        for (int i = 0; i < size; i++) {
            createWork(THREAD_NAME);
        }
    }

    //创建实际工作--创建工作并加入实际工作队列中
    private void createWork(String name) {
        Worker worker = new Worker(threadGroup, name + (seq++));
        worker.start();
        TASK_QUEUE.add(worker);
    }

    //线程状态枚举类
    private enum ThreadState {
        FREE, RUNNING, BLOCKED, DEAD;
    }

    //进行写操作
    public void submit(Runnable runnable) {
        synchronized (WORK_QUEUE) {
            WORK_QUEUE.addLast(runnable);
            WORK_QUEUE.notifyAll();
        }
    }

    /**
     * 工作线程
     */
    private static class Worker extends Thread {
        //线程的初始状态
        private volatile ThreadState status = ThreadState.FREE;

        //获取线程的状态
        public ThreadState getThreadState() {
            return this.status;
        }

        public Worker(ThreadGroup threadGroup, String name) {
            super(threadGroup, name);
        }

        //让线程执行任务，而且不能挂掉
        @Override
        public void run() {
            OUTER:
            //状态不能DEAD
            while (this.status != ThreadState.DEAD) {
                //取任务
                Runnable runnable;
                //进行读操作
                synchronized (WORK_QUEUE) {
                    while (WORK_QUEUE.isEmpty()) {//如果没有人提交工作
                        try {
                            status = ThreadState.BLOCKED;//在wait的时候状态就发生了变化
                            WORK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            break OUTER;
                        }
                    }
                    runnable = WORK_QUEUE.removeFirst();//拿出来一个工作
                   /* if (runnable != null){
                        status = ThreadState.RUNNING;//在run的时候状态就发生了变化
                        runnable.run();
                        status = ThreadState.FREE;//运行完后变成了FREE
                    }*/
                }

                if (runnable != null) {
                    status = ThreadState.RUNNING;//在run的时候状态就发生了变化
                    runnable.run();
                    status = ThreadState.FREE;//运行完后变成了FREE
                }
            }
        }

        /**
         * 关闭线程池链接
         */
        public void close() {
            this.status = ThreadState.DEAD;
        }
    }

    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool();
        IntStream.range(1, 40).forEach(i -> {
            pool.submit(() -> {
                System.out.println("the task is " + Thread.currentThread().getName() + " start.");
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("the task is " + Thread.currentThread().getName() + " finished.");
            });
        });

    }
}
