package com.xbniao.mst;

/**
 * @Author: Carlos Zhang
 * @Date: 2019/2/18 9:47
 */
public interface IMySet<E> {
    boolean add(E e);

    boolean remove(E e);

    boolean contains(E e);

    int size();
}
