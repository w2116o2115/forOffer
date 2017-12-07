package com.yixin.design;

interface Shape2 {
    void draw();
}

/**
 * Created by zw
 * Creates on 16/4/13.
 * 装饰器模式（Decorator Pattern）允许向一个现有的对象添加新的功能，同时又不改变其结构。这种类型的设计模式属于结构型模式，它是作为现有的类的一个包装。
 * 这种模式创建了一个装饰类，用来包装原有的类，并在保持类方法签名完整性的前提下，提供了额外的功能。
 * 动态地给一个对象添加一些额外的职责。就增加功能来说，装饰器模式相比生成子类更为灵活。
 */
public class myDecorator {
    public static void main(String[] args) {
        //其实就是动态的给circle增加接口!
        Shape2 circle = new Circle2();
        Shape2 redCircle = new RedShapeDecorator( new Circle2() );
        Shape2 redRectangle = new RedShapeDecorator( new Rectangle2() );
        System.out.println( "Circle with normal border" );
        circle.draw();
        System.out.println( "\nCircle of red border" );
        redCircle.draw();
        System.out.println( "\nRectangle of red border" );
        redRectangle.draw();
    }
}

class Rectangle2 implements Shape2 {
    public void draw() {
        System.out.println( "Shape: Rectangle" );
    }
}

class Circle2 implements Shape2 {
    public void draw() {
        System.out.println( "Shape: Circle" );
    }
}

abstract class ShapeDecorator implements Shape2 {
    protected Shape2 decoratedShape;

    public ShapeDecorator(Shape2 decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    public void draw() {
        decoratedShape.draw();
    }

}

class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape2 decoratedShape) {
        super( decoratedShape );
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder( decoratedShape );
    }

    private void setRedBorder(Shape2 decoratedShape) {
        System.out.println( "Border Color: Red" );
    }
}