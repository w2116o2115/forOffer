package com.yixin.design;

interface Sender {
    public void Sender();
}

/**
 * Created by zw
 * Creates on 16/4/12.
 * 不同工厂模式
 * 它的主要问题是  输入的参数有问题  就不能生成正确的类了
 */
public class myFactory {
    public static void main(String[] args) {
        myFactory factory = new myFactory();
        Sender sender = factory.produce( "mail" );
        sender.Sender();
    }

    public Sender produce(String msg) {
        if (msg == "mail") {
            return new MainSender();
        } else {
            return new SmsSender();
        }
    }
}

class MainSender implements Sender {

    public void Sender() {
        System.out.println( "发出mail" );
    }
}

class SmsSender implements Sender {

    public void Sender() {
        System.out.println( "发出Sms" );
    }
}
