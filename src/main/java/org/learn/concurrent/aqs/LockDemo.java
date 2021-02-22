package org.learn.concurrent.aqs;

import lombok.Setter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : gaoluu
 * @date : Created in 2:02 下午 2021/1/14
 */

public class LockDemo {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Thread thread1 = new Thread(new LockRunnable(lock,600000));
        thread1.start();
        Thread thread2 = new Thread(new LockRunnable(lock,2000));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }

    @Setter
    private static class LockRunnable implements Runnable {

        private Lock lock;
        private long timeout;

        public LockRunnable(Lock lock, long timeout) {
            this.lock = lock;
            this.timeout = timeout;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                Thread.sleep(timeout);
                System.out.println(Thread.currentThread().getName() + "run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

}
