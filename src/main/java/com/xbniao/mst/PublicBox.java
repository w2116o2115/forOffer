package com.xbniao.mst;

/**
 * 当线程执行wait()方法时候，会释放当前的锁，然后让出CPU，进入等待状态。
 * 只有当 notify/notifyAll() 被执行时候，才会唤醒一个或多个正处于等待状态的线程，然后继续往下执行，直到执行完synchronized 代码块的代码或是中途遇到wait() ，再次释放锁。
 *
 * 方法一：   wait()  和   notify()   通信方法实现
 * 生产-消费模式，必不可少需要两个角色：生产者（Producer）消费者（Customer），还有一个就是生产数据的厂房（Factory）
 * 这个类就相当于一个数据的厂房
 * @Author: Carlos Zhang
 * @Date: 2019/2/18 10:08
 */
public class PublicBox {
    private int apply = 0;//产品数量

    public synchronized void increate(){
        while (apply == 5){
            try{
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        apply++;
        System.out.println("生成苹果成功！");
        notify();
    }

    public synchronized void decCreate(){
        while (apply == 0){
            try{
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        apply--;
        System.out.println("苹果被消费了！");
        notify();
    }

    public static void main(String[] args) {
        PublicBox box= new PublicBox();

        Consumer con= new Consumer(box);
        Producer pro= new Producer(box);

        Thread t1= new Thread(con);
        Thread t2= new Thread(pro);

        t1.start();
        t2.start();
    }
}
