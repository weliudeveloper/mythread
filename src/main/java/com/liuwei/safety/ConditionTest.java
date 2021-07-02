package com.liuwei.safety;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wee
 * @Description:
 * @date 2020/6/8 10:54
 */
public class ConditionTest {

    private static Lock lock = new ReentrantLock();

    private static Condition condition = lock.newCondition();

    private static LinkedList<Long> linkedList = new LinkedList<>();

    private static boolean notUse = true;

    public static void main(String[] args) {
        linkedList.addLast(System.currentTimeMillis());
        new Thread(() -> {
            while (true) {
                provider();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                consumer();
            }
        }).start();
    }

    private static void provider() {
        try {
            lock.lock();
            while (notUse) {
                condition.await();
            }
            long value = System.currentTimeMillis();
            linkedList.addLast(value);
            System.out.println(Thread.currentThread().getName() + " P provider a data " + value);
            notUse = true;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private static void consumer() {
        try {
            lock.lock();
            while (!notUse) {
                condition.await();
            }
            Long value = linkedList.removeFirst();
            System.out.println(Thread.currentThread().getName() + " C consumer a data " + value);
            notUse = false;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
