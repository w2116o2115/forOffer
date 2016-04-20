package com.yixin.ThreadConcurrency;

import java.util.concurrent.*;

/**
 * Created by zw
 * Creates on 16/3/30.
 * 主要解决的问题, 提交多个线程作业,每个作业都会有一个结果,如果等到作业都执行结束才出结果,很慢
 * CompletionService 可以做到一部提交作业  异步获得结果!
 */
public class myCompletionService implements Callable<String> {//Callable 和 Runnable 的使用方法大同小异 call() 可以返回值， 而 run()方法不能返回。
    private int id;

    public myCompletionService(int i) {
        this.id = i;
    }

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();
        CompletionService<String> completion = new ExecutorCompletionService<String>(service);
        for (int i = 0; i < 10; i++) {
            completion.submit(new myCompletionService(i));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(completion.take().get());
        }
        service.shutdown();
    }

    public String call() throws Exception {
        Integer time = (int) (Math.random() * 1000);
        try {
            System.out.println(this.id + " start");
            Thread.sleep(time);
            System.out.println(this.id + " end");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.id + ":" + time;
    }
}


