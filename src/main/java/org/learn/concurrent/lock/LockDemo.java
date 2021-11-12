package org.learn.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : gaoluu
 * @date : Created in 11:11 下午 2020/12/15
 */

public class LockDemo {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        if (lock.tryLock()) {
            try {

            } finally {
                lock.unlock();
            }
        } else {
            //
        }
    }
}