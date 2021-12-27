package org.learn.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : gaoluu
 * @date : Created in 11:11 下午 2020/12/15
 */
public class LockDemo {

    private boolean m = true;
    Lock lock = new ReentrantLock();

    Thread thread1 = new Thread(() -> {
//        lock.lock();
//        try {
//            TimeUnit.SECONDS.sleep(5);
            m = false;
//            TimeUnit.SECONDS.sleep(60);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//
//        }
    });

    Thread thread2 = new Thread(() -> {
        while (m) {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("holding...");
        }
        System.out.println("exit!");
    });

    public static void main(String[] args) {
        LockDemo lockDemo = new LockDemo();
        lockDemo.thread2.start();
        int i = 10000000;
        while (i > 0) {
            i--;
        }
        lockDemo.thread1.start();
    }
}