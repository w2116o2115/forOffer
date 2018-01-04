package com.yixin.design;

/**
 * 一个策略接口
 */
interface Strategy {
    public int doOperation(int num1, int num2);
}

/**
 * Created by zw
 * Creates on 16/4/14.
 * 在策略模式
 * 在策略模式（Strategy Pattern）中，一个类的行为或其算法可以在运行时更改。这种类型的设计模式属于行为型模式。
 * 策略模式是指对一系列的算法定义，并将每一个算法封装起来，而且使它们还可以相互替换。
 * 策略模式让算法独立于使用它的客户而独立变化。
 */
public class myStrategy {
    public static void main(String[] args) {
        Context1 context = new Context1( new OperationAdd() );
        System.out.println( "10 + 5 = " + context.executeStrategy( 10, 5 ) );
        context = new Context1( new OperationSubstract() );
        System.out.println( "10 - 5 = " + context.executeStrategy( 10, 5 ) );
        context = new Context1( new OperationMultiply() );
        System.out.println( "10 * 5 = " + context.executeStrategy( 10, 5 ) );
    }
}

/**
 * 策略实现
 */
class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

class OperationSubstract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}

/**
 * 策略调用类
 */
class Context1 {
    private Strategy strategy;

    public Context1(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation( num1, num2 );
    }
}