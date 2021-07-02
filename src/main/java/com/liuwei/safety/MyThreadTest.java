package com.liuwei.safety;

/**
 * @author wee
 */
public class MyThreadTest {
    public static void main(String[] args) throws InterruptedException {
        //和JAVA中的策略模式类似
        final Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket, "一号台");
        Thread thread2 = new Thread(ticket, "二号台");
        Thread thread3 = new Thread(ticket, "三号台");
        thread1.start();
        thread2.start();
        thread3.start();
      /* TickerThread thread = new TickerThread("一号柜台");
       TickerThread thread2 = new TickerThread("二号柜台");
       TickerThread thread3 = new TickerThread("三号柜台");
        thread.start();
        thread2.start();
        thread3.start();*/
      /*  thread.join();
        thread2.join();
        thread3.join();*/

        /*Thread thread = new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(100);
                    } catch (Exception e){
                        System.out.println("我收到打断信号");
                        e.printStackTrace();
                    }
                }
            }
        };

        thread.start();
        System.out.println(thread.isInterrupted());
        thread.interrupt();
        System.out.println(thread.isInterrupted());*/

        /*  System.out.println(Thread.currentThread().getName() + "完成");*/
       /* Long start = System.currentTimeMillis();
          Thread thread = new Thread(new Runnable() {
              public void run() {
                  while (true){
                      try {
                          Thread.sleep(100000);
                          System.out.println("守护线程正在打印");
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }
              }
          });
          thread.setDaemon(true);//设置为守护线程，守护线程主要做一些无关紧要的事情，伴随着主线程的结束而结束
          thread.start();

          try {
              Thread.sleep(1000);
              Long end = System.currentTimeMillis();
              System.out.println("主线程结束了哦" + (end - start));
          } catch (Exception e){

        }*/

    }
}
