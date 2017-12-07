package com.yixin.design;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zw
 * Creates on 16/4/14.
 * 备忘录模式
 * 备忘录模式（Memento Pattern）保存一个对象的某个状态，以便在适当的时候恢复对象。备忘录模式属于行为型模式。
 */
public class myMemento {
    public static void main(String[] args) {
        //创建备忘类
        Originator originator = new Originator();
        //创建测试类
        CareTaker careTaker = new CareTaker();
        //备忘类设置属性
        originator.setState( "State #1" );
        //备忘类设置属性
        originator.setState( "State #2" );
        //保存备忘类的属性  到保存属性类
        careTaker.add( originator.saveStateToMemento() );
        originator.setState( "State #3" );
        careTaker.add( originator.saveStateToMemento() );
        originator.setState( "State #4" );
        System.out.println( "Current State: " + originator.getState() );
        originator.getStateFromMemento( careTaker.get( 0 ) );
        System.out.println( "First saved State: " + originator.getState() );
        originator.getStateFromMemento( careTaker.get( 1 ) );
        System.out.println( "Second saved State: " + originator.getState() );
    }
}

/**
 * 需要保存的属性
 */
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

/**
 * 备忘类!!
 */
class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMemento() {
        return new Memento( state );
    }

    public void getStateFromMemento(Memento Memento) {
        state = Memento.getState();
    }
}

/**
 * 一个类的集合  用来测试备忘属性
 */
class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state) {
        mementoList.add( state );
    }

    public Memento get(int index) {
        return mementoList.get( index );
    }
}