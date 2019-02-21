package com.xbniao.mst;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 方法二：采用阻塞队列实现生产者消费者模式
 *
 * 阻塞队列实现生产者消费者模式超级简单，它提供开箱即用支持阻塞的方法put()和take()，开发者不需要写困惑的wait-nofity代码去实现通信。BlockingQueue 一个接口，
 * Java5提供了不同的现实，如ArrayBlockingQueue和LinkedBlockingQueue，两者都是先进先出（FIFO）顺序。而ArrayLinkedQueue是自然有界的，LinkedBlockingQueue可选的边界。
 * 下面这是一个完整的生产者消费者代码例子，对比传统的wait、nofity代码，它更易于理解。
 * @Author: Carlos Zhang
 * @Date: 2019/2/18 10:42
 */
public class PublicBoxQueue {
    public static void main(String []args) {
        BlockingQueue publicBoxQueue= new LinkedBlockingQueue(5);   //定义了一个大小为5的盒子

        Thread pro= new Thread(new ProducerQueue(publicBoxQueue));
        Thread con= new Thread(new ConsumerQueue(publicBoxQueue));

        pro.start();
        con.start();
    }
}
