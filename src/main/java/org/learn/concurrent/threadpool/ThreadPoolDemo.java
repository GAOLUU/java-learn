package org.learn.concurrent.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author : gaoluu
 * @date : Created in 2:59 下午 2021/1/5
 */
public class ThreadPoolDemo {

    private final static long MINUTE_10 = 1000 * 60 * 10L;
    private final static long MINUTE_1 = 1000 * 60 * 1L;
    private final static long SECOND_5 = 1000 * 5L;

    private volatile boolean sign = true;

    private ThreadPoolExecutor executor = null;

    public ThreadPoolDemo(ThreadPoolExecutor executor) {
        this.executor = executor;
    }

    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(1);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 10, TimeUnit.SECONDS, queue);
        ThreadPoolDemo demo = new ThreadPoolDemo(executor);

        // RUNNING -> SHUTDOWN -> TIDYING -> TERMINATED
//        demo.shutDownTest();

        // RUNNING -> STOP -> TIDYING -> TERMINATED
//        demo.shutDownNowTest();

        // addAndRunWorker
//        demo.addAndRunWorkerTest();

        // throwException
//        demo.throwExceptionTest();

        // getTask
        demo.getTaskTest();

    }

    public void shutDownTest() {
        executor.execute(() -> {
            try {
                Thread.sleep(MINUTE_1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.shutdown();
        executor.execute(() ->
                System.out.println(Thread.currentThread().getName())
        );
    }

    public void shutDownNowTest() {

        executor.execute(() -> {
            try {
                deadLoopThrow();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.shutdownNow();
    }

    public void addAndRunWorkerTest() {
        executor.setKeepAliveTime(10, TimeUnit.SECONDS);
        executor.allowCoreThreadTimeOut(true);
        executor.execute(() -> {
            try {
                deadLoopThrow();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("addWorkerTest");
        executor.execute(() ->
                System.out.println("add second worker!")
        );
    }

    public void throwExceptionTest() {
        executor.execute(() -> {
            throwException();
        });
    }

    public void getTaskTest() {
        executor.setCorePoolSize(1);
        executor.setKeepAliveTime(10, TimeUnit.SECONDS);
        executor.allowCoreThreadTimeOut(true);
        executor.execute(() -> {
            while (sign) {
                System.out.println("first task running");
            }
            System.out.println("first task exit!");
        });
        executor.execute(() -> {
            System.out.println("second task run");
        });
        sign = false;
    }

    private void deadLoopThrow() throws InterruptedException {
        while (true) {
            System.out.println("i'm alive!");
            if (Thread.interrupted()) {
                throw new InterruptedException("响应中断");
            }
        }
    }

    private void throwException() {
        throw new RuntimeException("test exception");
    }

}
