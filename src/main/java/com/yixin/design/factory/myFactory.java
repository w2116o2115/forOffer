package com.yixin.design.factory;

/**
 * Product: 需要创建的产品的抽象类.
 *
 * @author Andy.Chen
 */
abstract class Shape {

    public String name;

    public Shape(String aName) {
        this.name = aName;
    }

    //绘画
    public abstract void draw();

    //擦除
    public abstract void erase();
}

/**
 * 圆形子类(ConcreteProduct: Product的子类,一系列具体的产品.)
 * @author Andy.Chen
 *
 */
class Circle extends Shape{

    public Circle(String name) {
        super(name);
    }

    @Override
    public void draw() {
        System.out.println("It will draw a Circle");
    }

    @Override
    public void erase() {
        System.out.println("It will erase a Circle");
    }

}

/**
 * 方形子类(ConcreteProduct: Product的子类,一系列具体的产品.)
 * @author Andy.Chen
 *
 */
class Square extends Shape{

    public Square(String name) {
        super(name);
    }

    @Override
    public void draw() {
        System.out.println("It will draw a Square");
    }

    @Override
    public void erase() {
        System.out.println("It will erase a Square");
    }

}

/**
 * Creator: 抽象创建器接口,声明返回Product类型对象的Factory Method.
 * @author Andy.Chen
 *
 */
abstract class ShapeFactory {

    protected abstract Shape factoryMethod(String aName);

    public void anOperation(String aName){
        Shape s = factoryMethod(aName);
        System.out.println("The current shape is: " + s.name);
        s.draw();
        s.erase();
    }

}

/**
 * ConcreteCreator: 具体的创建器,重写Creator中的Factory Method,
 * 返回ConcreteProduct类型的实例.
 * @author Andy.Chen
 *
 */
class CircleFactory extends ShapeFactory {

    @Override
    protected Shape factoryMethod(String aName) {
        return new Circle(aName + " (created by CircleFactory)");
    }

}

/**
 * ConcreteCreator: 具体的创建器,重写Creator中的Factory Method,
 * 返回ConcreteProduct类型的实例.
 * @author Andy.Chen
 *
 */
class SquareFactory extends ShapeFactory {

    @Override
    protected Shape factoryMethod(String aName) {
        return new Square( aName + " (created by SquareFactory)" );
    }
}


    /**
 * Created by zw
 * Creates on 16/4/12.
 * 不同工厂模式
 * 它的主要问题是  输入的参数有问题  就不能生成正确的类了
 */
public class myFactory {
    public static void main(String[] args) {
        ShapeFactory sf1 = new CircleFactory();
        ShapeFactory sf2 = new SquareFactory();

        System.out.println("Welcome to Andy.Chen Blog!" +"\n"
                +"Factory Method Patterns." +"\n"
                +"-------------------------------");

        sf1.anOperation("Shape-Circle");
        sf2.anOperation("Shape-Square");

    }
}