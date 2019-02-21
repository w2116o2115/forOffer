package com.xbniao.mst;

import java.util.HashMap;

/**
 * 实现一个简单hashset
 * HashSet底层的数据存取是通过HashMap实现的
 * 换句话说，如果了解HashMap，那么HashSet就非常容易了
 * HashSet大部分的方法都是直接调用HashMap的方法就可以实现的
 * @Author: Carlos Zhang
 * @Date: 2019/2/18 9:48
 */
public class MyHashSet<E> implements IMySet<E> {
    HashMap<E,Object> map;

    static final Object pre = new Object();

    public MyHashSet() {
        this.map = new HashMap<E, Object>();
    }


    @Override
    public boolean add(E e) {
        return map.put(e,pre) == null;
    }


    @Override
    public boolean remove(E e) {
        return map.remove(e) == pre;
    }


    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }


    @Override
    public int size() {
        return map.size();
    }
}
