package com.liuwei.safety;

/**
 * @author wee
 */
public class MyThreadTestApi {

    private static boolean is_run = true;

    public static void main(String[] args) {
        final Thread thread1 = new Thread() {
            @Override
            public void run() {
                while (is_run) {
                    System.out.println("我一直在运行");
                }
            }
        };

        thread1.start();
        try {
            Thread.sleep(1000);
            isNotRun();
        } catch (InterruptedException e) {

        }

        MyThreadService service = new MyThreadService();
        service.execute(new Runnable() {
            public void run() {
                //加载资源
                while (true) {
                    System.out.println("我在加载重量资源");
                }
            }
        });
        Long start = System.currentTimeMillis();
        Thread main = Thread.currentThread();
        main.interrupt();
        service.shutDown(4);
        Long end = System.currentTimeMillis();
        System.out.println(end - start + "我是main哦");
    }

    private static void isNotRun() {
        is_run = false;
    }
}
