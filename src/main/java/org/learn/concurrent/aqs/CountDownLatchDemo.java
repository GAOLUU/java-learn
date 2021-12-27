package org.learn.concurrent.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author : gaoluu
 * @date : Created in 4:39 下午 2021/12/6
 */

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread thread1 = new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread1 exe...");
        });

        Thread thread2 = new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread2 exe...");
        });


        Thread thread3 = new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread3 exe...");
        });
        thread1.start();
        thread2.start();
        TimeUnit.SECONDS.sleep(1L);
        countDownLatch.countDown();
        thread3.start();

    }

}
