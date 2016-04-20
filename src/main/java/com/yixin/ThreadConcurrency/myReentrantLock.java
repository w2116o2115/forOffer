package com.yixin.ThreadConcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zw
 * Creates on 16/3/30.
 * ReentrantLock : 重入锁
 * 一个可重入的互斥锁定 Lock，它具有与使用 synchronized 方法和语句所访问的隐式监视器锁定相同的一些基本行为和语义，但功能更强大。
 * ReentrantLock 将由最近成功获得锁定，并且还没有释放该锁定的线程所拥有。当锁定没有被另一个线程所拥有时，调用 lock 的线程将成功获取该锁定并返回。
 * 如果当前线程已经拥有该锁定，此方法将立即返回。可以使用 isHeldByCurrentThread() 和 getHoldCount() 方法来检查此情况是否发生。
 * 此类的构造方法接受一个可选的公平参数。
 * 当设置为 true时，在多个线程的争用下，这些锁定倾向于将访问权授予等待时间最长的线程。否则此锁定将无法保证任何特定访问顺序。
 * 与采用默认设置（使用不公平锁定）相比，使用公平锁定的程序在许多线程访问时表现为很低的总体吞吐量（即速度很慢，常常极其慢），
 * 但是在获得锁定和保证锁定分配的均衡性时差异较小。不过要注意的是，公平锁定不能保证线程调度的公平性。因此，使用公平锁定的众多
 * 线程中的一员可能获得多倍的成功机会，这种情况发生在其他活动线程没有被处理并且目前并未持有锁定时。还要注意的是，未定时的 tryLock
 * 方法并没有使用公平设置。因为即使其他线程正在等待，只要该锁定是可用的，此方法就可以获得成功。
 */
public class myReentrantLock extends Thread {
    TestReentrantLock lock;
    private int id;

    public myReentrantLock(int i, TestReentrantLock test) {
        this.id = i;
        this.lock = test;
    }

    public static void main(String args[]) {
        ExecutorService service = Executors.newCachedThreadPool();
        TestReentrantLock lock = new TestReentrantLock();
        for (int i = 0; i < 10; i++) {
            service.submit(new myReentrantLock(i, lock));
        }
        service.shutdown();
    }

    public void run() {
        lock.print(id);
    }
}

class TestReentrantLock {
    private ReentrantLock lock = new ReentrantLock();

    public void print(int str) {
        try {
            lock.lock();
            System.out.println(str + "获得");
            Thread.sleep((int) (Math.random() * 1000));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(str + "释放");
            lock.unlock();
        }
    }
}
