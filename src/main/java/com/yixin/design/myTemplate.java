package com.yixin.design;

/**
 * Created by zw
 * Creates on 16/4/14.
 * 在模板模式（Template Pattern）中，
 * 一个抽象类公开定义了执行它的方法的方式/模板。它的子类可以按需要重写方法实现，
 * 但调用将以抽象类中定义的方式进行。这种类型的设计模式属于行为型模式。
 * <p/>
 * 主要解决：一些方法通用，却在每一个子类都重新写了这一方法。
 */
public class myTemplate {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}

/**
 * 模板类 中定义了一个模板
 */
abstract class Game {
    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay(); //模板

    public final void play() { //初始化游戏
        initialize(); //开始游戏
        startPlay(); //结束游戏
        endPlay();
    }
}

/**
 * 我们将创建一个定义操作的 Game 抽象类，其中，模板方法设置为 final，
 * 这样它就不会被重写。Cricket 和 Football 是扩展了 Game 的实体类，
 * 它们重写了抽象类的方法。TemplatePatternDemo，我们的演示类使用 Game 来演示模板模式的用法。
 */
class Cricket extends Game {
    @Override
    void endPlay() {
        System.out.println( "Cricket Game Finished!" );
    }

    @Override
    void initialize() {
        System.out.println( "Cricket Game Initialized! Start playing." );
    }

    @Override
    void startPlay() {
        System.out.println( "Cricket Game Started. Enjoy the game!" );
    }
}

class Football extends Game {
    @Override
    void endPlay() {
        System.out.println( "Football Game Finished!" );
    }

    @Override
    void initialize() {
        System.out.println( "Football Game Initialized! Start playing." );
    }

    @Override
    void startPlay() {
        System.out.println( "Football Game Started. Enjoy the game!" );
    }
}