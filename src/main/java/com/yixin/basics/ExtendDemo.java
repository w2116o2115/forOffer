package com.yixin.basics;

/**
 * java静态绑定和动态绑定问题
 * java的属性都是静态绑定
 */
public class ExtendDemo {
    static class SubClass extends SuperClass
    {
        public String name = "SubClass";
        public void a(){
            System.out.println("SubClass");
        }
    }

    static class SuperClass
    {
        public String name = "SuperClass";
        public void a(){
            System.out.println("SuperClass");
        }
    }

    public static void main(String[] args) {
        SuperClass clz = new SubClass();
        //你觉得这里输出什么?
        System.out.println(clz.name);
        clz.a();
    }
}
