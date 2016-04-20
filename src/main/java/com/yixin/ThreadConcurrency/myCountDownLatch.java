package com.yixin.ThreadConcurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zw
 * Creates on 16/3/30.
 * 一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
 * CountDownLatch最重要的方法是countDown()和await()，前者主要是倒数一次，后者是等待倒数到0，如果没有到达0，就只有阻塞等待了。
 */
public class myCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        // 开始的倒数锁
        final CountDownLatch begin = new CountDownLatch(1);
        // 结束的倒数锁
        final CountDownLatch end = new CountDownLatch(10);
        // 十名选手
        final ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int index = 0; index < 10; index++) {
            final int NO = index + 1;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        begin.await();//一直阻塞
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("No." + NO + " arrived");
                    } catch (InterruptedException e) {
                    } finally {
                        end.countDown();
                    }
                }
            };
            exec.submit(run);
        }
        System.out.println("Game Start");
        begin.countDown();
        end.await();
        System.out.println("Game Over");
        exec.shutdown();
    }
}
