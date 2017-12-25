package com.yixin.design.decorator;

/**
 * Created by wei
 * Date 2017/12/22
 */
/** 牛仔裤 */
public class Jeans extends Decorator {

    @Override
    public void show(){
        System.out.println("穿牛仔裤");
        super.show();
    }

}