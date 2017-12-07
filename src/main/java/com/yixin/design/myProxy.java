package com.yixin.design;

interface Image {
    void display();
}

/**
 * Created by zw
 * Creates on 16/4/14.
 * 代理模式
 * 在代理模式中，我们创建具有现有对象的对象，以便向外界提供功能接口。
 * 主要解决：在直接访问对象时带来的问题，比如说：要访问的对象在远程的机器上。在面向对象系统中，有些对象由于某些原因（比如对象创建开销很大，
 * 或者某些操作需要安全控制，或者需要进程外的访问），直接访问会给使用者或者系统结构带来很多麻烦，我们可以在访问此对象时加上一个对此对象的访问层。
 */
public class myProxy {
    public static void main(String[] args) {
        Image image = new ProxyImage( "test_10mb.jpg" ); //图像将从磁盘加载
        image.display();
        System.out.println( "" ); //图像将无法从磁盘加载 image.display(); }
    }
}

class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk( fileName );
    }

    public void display() {
        System.out.println( "Displaying " + fileName );
    }

    private void loadFromDisk(String fileName) {
        System.out.println( "Loading " + fileName );
    }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage( fileName );
        }
        realImage.display();
    }
}