package org.learn.concurrent.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author : gaoluu
 * @date : Created in 3:46 下午 2021/11/23
 */

public class LockSupportDemo {


    public static void main(String[] args) {

        LockSupport.park();
        LockSupport.unpark(Thread.currentThread());
    }

}
