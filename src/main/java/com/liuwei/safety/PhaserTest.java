package com.liuwei.safety;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author wee
 * @Description:
 * @date 2020/6/8 16:28
 */
public class PhaserTest {

    public static void main(String[] args) {
        final Phaser phaser = new Phaser(2);
//        IntStream.rangeClosed(1,5).boxed().map(i-> phaser).forEach(Task::new);
      /*  for (int i = 0; i < 5; i++) {
            new Task(phaser);
        }
        phaser.register();
        phaser.arriveAndAwaitAdvance();
        System.out.println("all worker is done");*/

        /*for (int i = 1; i < 6; i++) {
            new SportsMen(i, phaser).start();
        }*/
        phaser.arriveAndDeregister();
        new Thread(phaser::arriveAndAwaitAdvance).start();
    }

    static class Task extends Thread {
        private final Phaser phaser;

        Task(Phaser phaser) {
            this.phaser = phaser;
            this.phaser.register();
            start();
        }

        @Override
        public void run() {
            System.out.println("The worker " + getName() + " is working");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            phaser.arriveAndAwaitAdvance();
        }
    }

    static class SportsMen extends Thread {
        private final int no;
        private final Phaser phaser;

        SportsMen(int no, Phaser phaser) {
            this.no = no;
            this.phaser = phaser;
        }

        @Override
        public void run() {
            try {
                method(" start running", " end running");

                method(" start bicycle", " end bicycle");

                phaser.arriveAndDeregister();

                method(" start long jump", " end long jump");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        private void method(String start, String end) throws InterruptedException {
            System.out.println(no + start);
            TimeUnit.SECONDS.sleep(1);
            System.out.println(no + end);
            phaser.arriveAndAwaitAdvance();
        }
    }
}
