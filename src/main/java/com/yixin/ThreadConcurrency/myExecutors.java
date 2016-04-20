package com.yixin.ThreadConcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zw
 * Creates on 16/3/30.
 * newFixedThreadPool（固定大小线程池）创建一个可重用固定线程集合的线程池
 * newCachedThreadPool（无界线程池，可以进行自动线程回收）
 * 创建一个可根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用它们。
 * 对于执行很多短期异步任务的程序而言，这些线程池通常可提高程序性能。调用 execute
 * 将重用以前构造的线程（如果线程可用）。如果现有线程没有可用的，则创建一个新线程并
 * 添加到池中。终止并从缓存中移除那些已有 60 秒钟未被使用的线程。因此，长时间保持空
 * 闲的线程池不会使用任何资源。注意，可以使用 ThreadPoolExecutor 构造方法创建具有
 * 类似属性但细节不同（例如超时参数）的线程池。
 * newSingleThreadExecutor（单个后台线程）
 * 创建一个使用单个 worker 线程的 Executor，以无界队列方式来运行该线程。
 * 这些方法返回的都是ExecutorService对象，这个对象可以理解为就是一个线程池。
 * 这个线程池的功能还是比较完善的。可以提交任务submit()可以结束线程池shutdown()。
 */
public class myExecutors extends Thread {
    private int index;

    public myExecutors(int i) {
        this.index = i;
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {//提交的线程被放到一个“无界队列里”。这是一个有序队列（BlockingQueue，这个下面会说到）。  慢慢执行
            service.execute(new myExecutors(i));
        }
        System.out.println("submit finish");
        service.shutdown();
    }

    @Override
    public void run() {
        try {
            System.out.println("[" + this.index + "] start....");
            Thread.sleep((int) (Math.random() * 10000));
            System.out.println("[" + this.index + "] end.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
