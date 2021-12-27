package org.learn.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : gaoluu
 * @date : Created in 10:32 上午 2021/12/7
 */

public class ConditionDemo {

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread thread1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("thread1 starting wait...");
                condition.await();
                System.out.println("thread1 be signed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread thread2 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("thread2 starting sign...");
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        });

        thread1.start();
        TimeUnit.SECONDS.sleep(1);
        thread2.start();
    }

}
