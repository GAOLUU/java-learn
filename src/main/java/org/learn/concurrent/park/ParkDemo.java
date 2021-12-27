package org.learn.concurrent.park;

import lombok.SneakyThrows;

import java.util.concurrent.locks.LockSupport;

/**
 * @author : gaoluu
 * @date : Created in 4:18 下午 2021/1/14
 */

public class ParkDemo {

    public static void main(String[] args) {

        Thread thread = new Thread(new InnerPark());
        thread.start();
        thread.interrupt();
    }

    private static class InnerPark implements Runnable {
        @SneakyThrows
        @Override
        public void run() {
            Thread.sleep(10000);
            System.out.println(Thread.currentThread().isInterrupted());
            LockSupport.park(this);
            System.out.println("....");
            System.out.println(Thread.currentThread().isInterrupted());
        }
    }

}
