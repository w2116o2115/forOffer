package com.yixin.design.decorator;

/**
 * 装饰模式测试客户端
 * Decorator模式 主要是的作用是
 * 装饰模式(Decorator)，动态地给一个对象添加一些额外的职责，就增加功能来说，装饰模式比生成子类更为灵活。
 * @author Andy.Chen
 *
 */
public class DecoratorClient {

    public static void main(String[] args) {
        System.out.println("Welcome to Andy.Chen Blog!" +"\n"
                +"Decorator Patterns." +"\n");

        Person mPerson = new Person("Andy");

        Jeans mJeans = new Jeans();

        mJeans.decoratorObj(mPerson);
        mJeans.show();
    }

}