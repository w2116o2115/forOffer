package com.yixin.design;

//访问者 接口
interface Visitor {
    void visit(Subject3 sub);
}

//Subject类，accept方法，接受将要访问它的对象，getSubject()获取将要被访问的属性
//被访问 对象!
interface Subject3 {
    void accept(Visitor visitor);

    String getSubject();
}

/**
 * Created by zw
 * Creates on 16/4/14.
 * 在访问者模式（Visitor Pattern）
 * 我们使用了一个访问者类，它改变了元素类的执行算法。通过这种方式，元素的执行算法可以随着访问者改变而改变。
 * 这种类型的设计模式属于行为型模式。根据模式，元素对象已接受访问者对象，这样访问者对象就可以处理元素对象上的操作。
 * <p/>
 * 意图：主要将数据结构与数据操作分离。
 * 如何解决：在被访问的类里面加一个对外提供接待访问者的接口
 * 应用实例：您在朋友家做客，您是访问者，朋友接受您的访问，您通过朋友的描述，然后对朋友的描述做出一个判断，这就是访问者模式。
 * <p/>
 * 访问者模式的目的是封装一些施加于某种数据结构元素之上的操作。一旦这些操作需要修改的话，接受这个操作的数据结构则可以保持不变。
 */
public class myVisitor {
    public static void main(String[] args) {
        Visitor visitor = new MyVisitor();
        Subject3 sub = new MySubject();
        sub.accept( visitor );
    }
}

//访问者类
class MyVisitor implements Visitor {
    public void visit(Subject3 sub) {
        System.out.println( "visit the subject：" + sub.getSubject() );
    }
}

class MySubject implements Subject3 {
    public void accept(Visitor visitor) {
        visitor.visit( this );
    } //造作数据接口的访问者  通过accepet进来

    public String getSubject() {
        return "love";
    } //相当于数据接口
}
/*
访问者模式(Visitor)
•javax.lang.model.element.AnnotationValue和AnnotationValueVisitor
•javax.lang.model.element.Element和ElementVisitor
•javax.lang.model.type.TypeMirror和TypeVisitor
 */