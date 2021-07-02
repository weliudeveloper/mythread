package com.liuwei.safety.mode.readwrite;

/**
 * @author wee
 * @Description:
 * @date 2020/4/19 20:42
 */
public class SharedData {
    private final char[] data;//读和写的数据
    private final ReadWriteLock lock;

    public SharedData(int size) {
        this.data = new char[size];
        lock = new ReadWriteLock();
    }

    public void read() throws InterruptedException {
        try {
            lock.readLock();
            for (char c : data) {
                System.out.println(Thread.currentThread().getName() + "  正在进行读操作  ");
            }
        } finally {
            lock.readUnLock();
        }
    }


    public void write(String value) {
        try {
            lock.writeLock();
            for (int i = 0; i < data.length; i++) {
                data[i] = value.charAt(0);
            }
            System.out.println(Thread.currentThread().getName() + " 正在进行写操作  ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeUnLock();
        }
    }
}
