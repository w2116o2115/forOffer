package com.yixin.design;

/**
 * 静态内置类实现单例模式  -- 线程安全！
 * Created by wei
 * Date 2017/12/20
 */
public class MySingleton {
    private static class MySingletionHandler{
        private static  MySingleton mySingleton = new MySingleton();
    }

    private MySingleton(){}

    private MySingleton getInstance(){
        return MySingletionHandler.mySingleton;
    }
}
