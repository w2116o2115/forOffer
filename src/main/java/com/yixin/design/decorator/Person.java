package com.yixin.design.decorator;

/**
 * Created by wei
 * Date 2017/12/22
 */
public class Person implements Component{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name){
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println("装扮的" + name);
    }

}