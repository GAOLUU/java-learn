package org.learn.concurrent.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author : gaoluu
 * @date : Created in 4:12 下午 2022/1/24
 */

public class FutureDemo {

    private int division(int val) {
        return val / 10;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureDemo demo = new FutureDemo();
        CompletableFuture.completedFuture(demo.division(100))
                .whenCompleteAsync((result, error) -> {
                    try {
                        System.out.println(result / 0);
                    } catch (ArithmeticException e) {
                        throw new RuntimeException();
                    }
                }).get();

    }

}
