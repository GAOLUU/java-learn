package org.learn.concurrent.sync;

/**
 * @author : gaoluu
 * @date : Created in 3:52 下午 2021/11/12
 */

public class WaitNotify {
    private final static Object object = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (object) {
                for (int i = 1; i <= 99; i += 2) {
                    System.out.println(i);
                    try {
                        object.notifyAll();
                        object.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {

                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (object) {
                for (int i = 2; i <= 100; i += 2) {
                    System.out.println(i);
                    try {
                        object.notifyAll();
                        object.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {

                    }
                }
            }
        });

        t1.start();
        t2.start();
    }

}
