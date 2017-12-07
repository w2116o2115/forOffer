package com.yixin.design;

interface Provider {
    Sender produce();
}

/**
 * Created by zw
 * Creates on 16/4/12.
 * 抽象工厂 - 扩展功能就不用修改工厂类了,再写一个就ok了!
 */
public class myAbstractFactory {
    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.Sender();
    }
}

class SendMailFactory implements Provider {

    public Sender produce() {
        return new MainSender();
    }
}

class SendSmsFactory implements Provider {

    public Sender produce() {
        return new SmsSender();
    }
}