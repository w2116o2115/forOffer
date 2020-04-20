package com.xbniao.jdk.learn;

/**
 * HashMap的要素之一，单链表的体现就在这里！
 * @author Carlose wei
 * @version 1.0
 * @date 2020/4/20 14:48
 */
public class MyEntry<K,V> implements MyMap.Entry {

    private K key;
    private V value;
    public MyEntry<K,V> next;

    public MyEntry(){}

    public MyEntry(K key, V value, MyEntry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
