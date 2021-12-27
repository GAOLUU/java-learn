package org.learn.concurrent.thread;

/**
 * @author : gaoluu
 * @date : Created in 3:16 下午 2021/11/23
 */

public class InterruptDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("开始sleep！");
            Thread.currentThread().interrupt();
            System.out.println("结束sleep！");
        });

        thread.start();
    }

}
