package com.xbniao.jdk.learn;

/**
 * @author Carlose wei
 * @version 1.0
 * @date 2020/4/20 15:25
 */
public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<String,String> map = new MyHashMap<String, String>();
        for (int i=0;i<500;i++){
            map.put("key"+i,"value"+i);
        }

        for (int i=0;i<500;i++){
            System.out.println("key"+i+",value is :" + map.get("key"+i));
        }
    }
}
