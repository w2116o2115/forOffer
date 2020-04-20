package com.xbniao.jdk.learn;

/**
 * @author Carlose wei
 * @version 1.0
 * @date 2020/4/20 14:37
 */
public interface MyMap<K,V> {
    public V put(K k,V v);

    public V get(K k);

    interface Entry<K,V>{
        public K getKey();
        public V getValue();
    }
}
