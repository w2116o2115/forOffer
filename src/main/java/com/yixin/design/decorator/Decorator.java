package com.yixin.design.decorator;

/**
 * Created by wei
 * Date 2017/12/22
 */
public class Decorator implements Component{

    private Component mComponent;

    public void decoratorObj(Component component){
        mComponent = component;
    }

    @Override
    public void show() {

        if(mComponent != null){
            mComponent.show();
        }
    }

}