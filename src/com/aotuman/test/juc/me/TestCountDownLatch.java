package com.aotuman.test.juc.me;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TestCountDownLatch {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread t1 = new Thread(() -> {
            try {
                System.out.println("t1 start----------");
                countDownLatch.await();
                TimeUnit.SECONDS.sleep(2);
                System.out.println("t1 return----------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println("t2 start----------");
                TimeUnit.SECONDS.sleep(2);
                countDownLatch.countDown();
                System.out.println("t2 return----------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                System.out.println("t3 start----------");
                TimeUnit.SECONDS.sleep(2);
                countDownLatch.countDown();
                System.out.println("t3 return----------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("main exit----------");
    }
}
