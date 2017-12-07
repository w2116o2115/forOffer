package com.yixin.design;

/**
 * 画圆接口
 */
interface DrawAPI {
    void drawCircle(int radius, int x, int y);
}

/**
 * Created by zw
 * Creates on 16/4/13.
 * 桥接（Bridge）是用于把抽象化与实现化解耦，使得二者可以独立变化。这种类型的设计模式属于结构型模式，它通过提供抽象化和实现化之间的桥接结构，来实现二者的解耦。
 * 这种模式涉及到一个作为桥接的接口，使得实体类的功能独立于接口实现类。这两种类型的类可被结构化改变而互不影响。
 */
public class myBridge {
    public static void main(String[] args) {
        Shape1 redCircle = new Circle1( 100, 100, 10, new RedCircle() );
        Shape1 greenCircle = new Circle1( 100, 100, 10, new GreenCircle() );
        redCircle.draw();
        greenCircle.draw();
    }
}

/**
 * 画圆实现 , 红色的圆
 */
class RedCircle implements DrawAPI {

    public void drawCircle(int radius, int x, int y) {
        System.out.println( "Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", " + y + "]" );
    }
}

/**
 * 画圆实现 , 绿色的圆
 */
class GreenCircle implements DrawAPI {

    public void drawCircle(int radius, int x, int y) {
        System.out.println( "Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", " + y + "]" );
    }
}

/**
 * 抽象类  依赖DrawAPI, 作为一个桥  分离抽象化与实现化
 */
abstract class Shape1 {
    protected DrawAPI drawAPI;

    protected Shape1(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}

class Circle1 extends Shape1 {
    public int x, y, radius;

    public Circle1(int x, int y, int radius, DrawAPI drawAPI) {
        super( drawAPI );
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle( radius, x, y );
    }
}