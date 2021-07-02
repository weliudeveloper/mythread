package com.liuwei.safety;

import java.io.Closeable;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author wee
 * @Description:
 * @date 2020/6/18 15:48
 */
public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException, IOException {
        List<F> list = Arrays.asList(new F(), new F());
        Iterator<Closeable> iterator = list.stream().map(f -> (Closeable) f::foo).iterator();

        while (iterator.hasNext()) {
            iterator.next().close();
        }
    }

    static class F {
        public void foo() {
            System.out.println(" 我被调用了");
        }
    }

    static class MyDelay implements Delayed {

        private final String no;

        MyDelay(String no) {
            this.no = no;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return 0;
        }

        @Override
        public int compareTo(Delayed delayedObject) {
            MyDelay delay = (MyDelay) delayedObject;
            return this.no.compareTo(delay.getNo());
        }

        public String getNo() {
            return this.no;
        }
    }

    private static void synchronousQueue() throws InterruptedException {
        SynchronousQueue<String> queue = new SynchronousQueue();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                queue.poll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        boolean isSuccess = queue.offer("queue", 1, TimeUnit.SECONDS);
        System.out.println(isSuccess);
        executorService.shutdown();
    }

    private static void priorityBlockingQueue() {
        PriorityBlockingQueue<User> queue = new PriorityBlockingQueue(5, (Comparator.comparingInt(User::getId)));

        queue.add(new User(2));
        queue.add(new User(1));
        User user = queue.peek();
        System.out.println(user.getId());
    }

    static class User {
        Integer id;

        public User(Integer value) {
            this.id = value;
        }

        public Integer getId() {
            return id;
        }

    }

    private static void arrayBlockingQueue() throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(() -> {
            try {
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 1, TimeUnit.SECONDS);


        queue.put(1);
        queue.put(2);
        queue.put(3);
        queue.put(4);
        TimeUnit.SECONDS.sleep(1);
        scheduledExecutorService.shutdownNow();
    }
}
