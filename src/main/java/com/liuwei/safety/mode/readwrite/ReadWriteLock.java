package com.liuwei.safety.mode.readwrite;

/**
 * @author wee
 * @Description: 读写锁模式
 * @date 2020/4/19 20:37
 */
public class ReadWriteLock {
    private int reading_readers = 0;
    private int waiting_readers = 0;
    private int writing_writers = 0;
    private int waiting_waiters = 0;

    public synchronized void readLock() throws InterruptedException {
        this.waiting_readers++;
        try {
            while (writing_writers > 0) {
                this.wait();
            }
            this.reading_readers++;
        } finally {
            this.waiting_readers--;
        }
    }

    public synchronized void readUnLock() {
        reading_readers--;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        this.waiting_waiters++;
        try {
            while (reading_readers > 0 || writing_writers > 0) {
                this.wait();
            }
            this.writing_writers++;
        } finally {
            this.waiting_waiters--;
        }

    }

    public synchronized void writeUnLock() {
        this.writing_writers--;
        notifyAll();
    }
}
