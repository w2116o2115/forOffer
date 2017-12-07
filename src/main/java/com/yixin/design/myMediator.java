package com.yixin.design;

import java.util.Date;

/**
 * Created by zw
 * Creates on 16/4/14.
 * 中介者模式（Mediator Pattern）是用来降低多个对象和类之间的通信复杂性。这种模式提供了一个中介类，
 * 该类通常处理不同类之间的通信，并支持松耦合，使代码易于维护。中介者模式属于行为型模式。
 * <p/>
 * 意图：用一个中介对象来封装一系列的对象交互，中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。
 * 主要解决：对象与对象之间存在大量的关联关系，这样势必会导致系统的结构变得很复杂，同时若一个对象发生改变，我们也需要跟踪与之相关联的对象，同时做出相应的处理。
 * 何时使用：多个类相互耦合，形成了网状结构。
 */
public class myMediator {
    public static void main(String[] args) {
        User robert = new User( "Robert" );
        User john = new User( "John" );
        robert.sendMessage( "Hi! John!" );
        john.sendMessage( "Hello! Robert!" );
    }
}

/**
 * 中介者类
 */
class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println( new Date().toString() + " [" + user.getName() + "] : " + message );
    }
}

/**
 * user通过中介者类 发出消息!
 */
class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {
        ChatRoom.showMessage( this, message );
    }
}