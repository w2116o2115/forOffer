package com.yixin.design;

interface Shape3 {
    void draw();
}

/**
 * Created by zw
 * Creates on 16/4/13.
 * 外观模式（Facade Pattern）隐藏系统的复杂性，并向客户端提供了一个客户端可以访问系统的接口。
 * 这种类型的设计模式属于结构型模式，它向现有的系统添加一个接口，来隐藏系统的复杂性。
 */
public class myFacade {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}

class Rectangle3 implements Shape3 {
    public void draw() {
        System.out.println( "Rectangle::draw()" );
    }
}

class Circle3 implements Shape3 {
    public void draw() {
        System.out.println( "Circle::draw()" );
    }
}

class Square3 implements Shape3 {
    public void draw() {
        System.out.println( "Square::draw()" );
    }
}

class ShapeMaker {
    private Shape3 circle;
    private Shape3 rectangle;
    private Shape3 square;

    public ShapeMaker() {
        circle = new Circle3();
        rectangle = new Rectangle3();
        square = new Square3();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }

    public void drawSquare() {
        square.draw();
    }
}