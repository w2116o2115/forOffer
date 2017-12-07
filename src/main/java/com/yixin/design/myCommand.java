package com.yixin.design;

import java.util.ArrayList;
import java.util.List;

/**
 * 命令接口
 */
interface Order {
    void execute();
}

/**
 * Created by zw
 * Creates on 16/4/14.
 * 命令模式（Command Pattern）
 * 意图：将一个请求封装成一个对象，从而使您可以用不同的请求对客户进行参数化。
 * 主要解决：在软件系统中，行为请求者与行为实现者通常是一种紧耦合的关系，但某些场合，
 * 比如需要对行为进行记录、撤销或重做、事务等处理时，这种无法抵御变化的紧耦合的设计就不太合适。
 * <p>
 * 是为了解决命令的请求者和命令的实现者之间的耦合关系
 */
public class myCommand {
    public static void main(String[] args) {
        //命令的实际执行者
        Stock abcStock = new Stock();
        //建立命令 传入知行社
        BuyStock buyStockOrder = new BuyStock( abcStock );
        SellStock sellStockOrder = new SellStock( abcStock );

        //建立调用者  传入命令  顺序执行
        Broker broker = new Broker();
        broker.takeOrder( buyStockOrder );
        broker.takeOrder( sellStockOrder );
        broker.placeOrders();

        broker.placeOrders();
    }
}

/**
 * 命令实体
 */
class BuyStock implements Order {
    private Stock abcStock;

    public BuyStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.buy();
    }
}

/**
 * 命令实体
 */
class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.sell();
    }
}

/**
 * 创建一个请求类
 */
class Stock {
    private String name = "ABC";
    private int quantity = 10;

    public void buy() {
        System.out.println( "Stock [ Name: " + name + ", Quantity: " + quantity + " ] bought" );
    }

    public void sell() {
        System.out.println( "Stock [ Name: " + name + ", Quantity: " + quantity + " ] sold" );
    }
}

/**
 * 命令的调用者
 */
class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order) {
        orderList.add( order );
    }

    public void placeOrders() {
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}