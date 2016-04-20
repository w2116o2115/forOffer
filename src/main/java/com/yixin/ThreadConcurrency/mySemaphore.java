package com.yixin.ThreadConcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by zw
 * Creates on 16/3/30.
 * Semaphore:一个计数信号量
 * Semaphore 通常用于限制可以访问某些资源（物理或逻辑的）的线程数目
 * 例如，下面的类使用信号量控制对内容池的访问：
 * 这里是一个实际的情况，大家排队上厕所，厕所只有两个位置，来了10个人需要排队。
 * 逻辑:
 * 一个计数信号量。从概念上讲，信号量维护了一个许可集合。如有必要，在许可可用前会阻塞每一个 acquire()，
 * 然后再获取该许可。每个 release() 添加一个许可，从而可能释放一个正在阻塞的获取者。
 */
public class mySemaphore extends Thread {
    Semaphore position;
    private int id;

    public mySemaphore(int i, Semaphore s) {
        this.id = i;
        this.position = s;
    }

    public static void main(String args[]) {
        ExecutorService list = Executors.newCachedThreadPool();
        Semaphore position = new Semaphore(2);
        for (int i = 0; i < 10; i++) {
            list.submit(new mySemaphore(i + 1, position));
        }
        list.shutdown();
        position.acquireUninterruptibly(2);
        System.out.println("使用完毕，需要清扫了");
        position.release(2);
    }

    public void run() {
        try {
            if (position.availablePermits() > 0) { //2个许可
                System.out.println("顾客[" + this.id + "]进入厕所，有空位");
            } else {
                System.out.println("顾客[" + this.id + "]进入厕所，没空位，排队");
            }
            position.acquire();//获得许可
            System.out.println("顾客[" + this.id + "]获得坑位");
            Thread.sleep((int) (Math.random() * 50000));
            System.out.println("顾客[" + this.id + "]使用完毕");
            position.release();//释放许可
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
