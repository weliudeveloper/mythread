package com.liuwei.safety;

/**
 * @author wee
 */
public class MyThreadService {

    /**
     * 执行线程
     */
    private Thread executeThread;

    /**
     * 判断守护线程是否结束
     */
    private static boolean is_run = false;

    public void execute(final Runnable task) {
        /**
         * 时间
         */
        final Long start = System.currentTimeMillis();
        executeThread = new Thread() {
            @Override
            public void run() {
                Thread guardThread = new Thread(task);
                guardThread.setDaemon(true);//设置为守护线程
                guardThread.start();
                try {
                    guardThread.join();//执行线程要等待守护线程结束
                    System.out.println("总共加载花费时间：" + (System.currentTimeMillis() - start));
                    is_run = true;
                } catch (InterruptedException e) {
                    System.out.println("我是守护线程哦");
                }
            }
        };
        executeThread.start();
    }

    public void shutDown(long millis) {
        /**
         * 时间
         */
        Long start = System.currentTimeMillis();
        while (!is_run) {
            /**
             * 超时
             */
            if ((System.currentTimeMillis() - start) >= millis) {
                System.out.println("任务超时咯");
                executeThread.interrupt();//中断执行线程
                break;
            }
            try {
                Thread.sleep(1);
                System.out.println("我依然存在");
            } catch (Exception e) {
                System.out.println("执行线程被打断");
                break;
            }
        }
        is_run = false;
    }
}
