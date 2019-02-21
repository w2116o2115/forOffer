package com.xbniao.mst;

import java.util.concurrent.BlockingQueue;

/**
 * @Author: Carlos Zhang
 * @Date: 2019/2/18 10:41
 */
public class ConsumerQueue implements Runnable{
    private final BlockingQueue conQueue;

    public ConsumerQueue(BlockingQueue conQueue) {
        this .conQueue =conQueue;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++)
        {
            try {
                System. out .println("消费者消费的苹果编号为 ：" +conQueue .take());
                Thread. sleep(3000);  //在这里sleep是为了看的更加清楚些
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }
}
