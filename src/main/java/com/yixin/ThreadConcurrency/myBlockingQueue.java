package com.yixin.ThreadConcurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by zw
 * Creates on 16/3/30.
 * 支持两个附加操作的 Queue，这两个操作是：检索元素时等待队列变为非空，以及存储元素时等待空间变得可用。
 * BlockingQueue 不接受 null 元素。试图 add、put 或 offer 一个 null 元素时，某些实现会抛出 NullPointerException。null 被用作指示 poll 操作失败的警戒值。
 * BlockingQueue 可以是限定容量的。它在任意给定时间都可以有一个 remainingCapacity，超出此容量，便无法无阻塞地 put 额外的元素。
 * <p/>
 * <p/>
 * BlockingQueue 实现主要用于生产者-使用者队列
 * add(anObject)：把anObject加到BlockingQueue里，如果BlockingQueue可以容纳，则返回true，否则抛出异常。
 * offer(anObject)：表示如果可能的话，将anObject加到BlockingQueue里，即如果BlockingQueue可以容纳，则返回true，否则返回false。
 * put(anObject)：把anObject加到BlockingQueue里，如果BlockingQueue没有空间，则调用此方法的线程被阻断直到BlockingQueue里有空间再继续。
 * poll(time)：取走BlockingQueue里排在首位的对象，若不能立即取出，则可以等time参数规定的时间，取不到时返回null。
 * take()：取走BlockingQueue里排在首位的对象，若BlockingQueue为空，阻断进入等待状态直到BlockingQueue有新的对象被加入为止。
 */
public class myBlockingQueue extends Thread {
    public static BlockingQueue<String> queue = new LinkedBlockingQueue<String>(3);
    private int index;

    public myBlockingQueue(int i) {
        this.index = i;
    }

    public static void main(String args[]) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            service.submit(new myBlockingQueue(i));
        }
        Thread thread = new Thread() {
            public void run() {
                try {
                    while (true) {
                        Thread.sleep((int) (Math.random() * 1000));
                        if (myBlockingQueue.queue.isEmpty())
                            break;
                        String str = myBlockingQueue.queue.take();
                        System.out.println(str + " has take!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        service.submit(thread);
        service.shutdown();
    }

    public void run() {
        try {
            queue.put(String.valueOf(this.index));
            System.out.println("{" + this.index + "} in queue!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
