package com.yixin.design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zw
 * Creates on 16/4/13.
 * 原型模式
 * 用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
 * 关键代码： 1、实现克隆操作，在 JAVA 继承 Cloneable，重写 clone()
 */
public class myPrototype {
    private static Map<String, Shape> shapeMap = new HashMap<String, Shape>();

    public static Shape getShape(String shapeId) throws CloneNotSupportedException {
        Shape cachedShape = shapeMap.get( shapeId );
        return (Shape) cachedShape.clone();
    }

    // 对每种形状都运行数据库查询，并创建该形状
    // shapeMap.put(shapeKey, shape);
    // 例如，我们要添加三种形状
    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId( "1" );
        shapeMap.put( circle.getId(), circle );
        Square square = new Square();
        square.setId( "2" );
        shapeMap.put( square.getId(), square );
        Rectangle rectangle = new Rectangle();
        rectangle.setId( "3" );
        shapeMap.put( rectangle.getId(), rectangle );
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        myPrototype.loadCache();
        Shape clonedShape = (Shape) myPrototype.getShape( "1" );
        System.out.println( "Shape : " + clonedShape.getType() );
        Shape clonedShape2 = (Shape) myPrototype.getShape( "2" );
        System.out.println( "Shape : " + clonedShape2.getType() );
        Shape clonedShape3 = (Shape) myPrototype.getShape( "3" );
        System.out.println( "Shape : " + clonedShape3.getType() );

    }
}

/**
 * 形状抽象类, 可克隆的
 */
abstract class Shape implements Cloneable {
    public String id;
    public String type;

    abstract void draw();

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}

/**
 * 长方形类
 */
class Rectangle extends Shape {
    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println( "Inside Rectangle::draw() method." );
    }
}

/**
 * 正方形类
 */
class Square extends Shape {
    public Square() {
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println( "Inside Square::draw() method." );
    }
}

/**
 * 圆形
 */
class Circle extends Shape {
    public Circle() {
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println( "Inside Circle::draw() method." );
    }
}