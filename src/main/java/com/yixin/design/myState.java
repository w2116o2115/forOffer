package com.yixin.design;

/**
 * 状态类
 */
interface State {
    public void doAction(Context context);
}

/**
 * Created by zw
 * Creates on 16/4/14.
 * 状态模式
 * 在状态模式（State Pattern）中，类的行为是基于它的状态改变的。这种类型的设计模式属于行为型模式。
 * 主要解决：对象的行为依赖于它的状态（属性），并且可以根据它的状态改变而改变它的相关行为。
 */
public class myState {
    public static void main(String[] args) {
        Context context = new Context();
        StartState startState = new StartState();
        startState.doAction( context );
        System.out.println( context.getState().toString() );
        StopState stopState = new StopState();
        stopState.doAction( context );
        System.out.println( context.getState().toString() );
    }
}

/**
 * Context 是一个带有某个状态的类
 */
class Context {
    private State state; //带有一个状态

    public Context() {
        state = null;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

/**
 * 开状态
 */
class StartState implements State {
    public void doAction(Context context) {
        System.out.println( "Player is in start state" );
        context.setState( this );
    }

    public String toString() {
        return "Start State";
    }
}

/**
 * 关状态
 */
class StopState implements State {
    public void doAction(Context context) {
        System.out.println( "Player is in stop state" );
        context.setState( this );
    }

    public String toString() {
        return "Stop State";
    }
}