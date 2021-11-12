package org.learn.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author : gaoluu
 * @date : Created in 11:54 下午 2020/12/15
 */

public class ReadWriteLockDemo {

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    public void reader() {
        readLock.lock();
        try {
            // 在此区域读取共享变量
        }finally {
            readLock.unlock();
        }
    }

    public void write() {
        writeLock.lock();
        try {
            // 在此区域访问（读、写）共享变量
        }finally {
            writeLock.unlock();
        }
    }
}