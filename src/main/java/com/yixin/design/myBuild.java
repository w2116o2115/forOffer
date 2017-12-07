package com.yixin.design;

import java.util.ArrayList;
import java.util.List;

/**
 * 食品条目接口:
 * 定了食品的名字,包装,机构
 */
interface Item {
    public String name();

    public Packing packing();

    public float price();
}

/**
 * 包装接口:
 * 定义了包装方法
 */
interface Packing {
    String pack();
}

/**
 * Created by zw
 * Creates on 16/4/13.
 * 建造者模式
 * 使用多个简单的对象一步一步构建成一个复杂的对象。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 */
public class myBuild {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println( "Veg Meal" );
        vegMeal.showItems();
        System.out.println( "Total Cost: " + vegMeal.getCost() );
        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println( "\n\nNon-Veg Meal" );
        nonVegMeal.showItems();
        System.out.println( "Total Cost: " + nonVegMeal.getCost() );
    }
}

/**
 * 纸盒包装类
 */
class Wrapper implements Packing {
    public String pack() {
        return "Wrapper";
    }
}

/**
 * 玻璃瓶包装类
 */
class Bottle implements Packing {
    public String pack() {
        return "Bottle";
    }
}

/**
 * 创建实现 Item 接口的抽象类，该类提供了默认的功能。
 * 汉堡抽象类
 */
abstract class Burger implements Item {
    public Packing packing() {
        return new Wrapper();
    }
}

/**
 * 可乐抽象类
 */
abstract class ColdDrink implements Item {
    public Packing packing() {
        return new Bottle();
    }
}

/**
 * 素食 汉堡
 */
class VegBurger extends Burger {
    public float price() {
        return 25.0f;
    }

    public String name() {
        return "Veg Burger";
    }
}

/**
 * 鸡肉汉堡
 */
class ChickenBurger extends Burger {
    public float price() {
        return 50.5f;
    }

    public String name() {
        return "Chicken Burger";
    }
}

/**
 * 可口可乐
 */
class Coke extends ColdDrink {
    public float price() {
        return 30.0f;
    }

    public String name() {
        return "Coke";
    }
}

/**
 * 百事可乐
 */
class Pepsi extends ColdDrink {
    public float price() {
        return 35.0f;
    }

    public String name() {
        return "Pepsi";
    }
}

/**
 * 定义一个套餐类
 */
class Meal {
    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item) {
        items.add( item );
    }

    public float getCost() {
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {
        for (Item item : items) {
            System.out.print( "Item : " + item.name() );
            System.out.print( ", Packing : " + item.packing().pack() );
            System.out.println( ", Price : " + item.price() );
        }
    }
}

/**
 * 套餐建造类  可以根据需要建造不同的 套餐!
 */
class MealBuilder {
    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem( new VegBurger() );
        meal.addItem( new Coke() );
        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem( new ChickenBurger() );
        meal.addItem( new Pepsi() );
        return meal;
    }
}