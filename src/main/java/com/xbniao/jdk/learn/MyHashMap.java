package com.xbniao.jdk.learn;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 作用：  1<<4 = 16
 *
 * 1.提醒你这个容量就是2的幂，扩容方式也是2的幂。
 *
 * 2.二的幂是使得Key Hash算法后的值尽可能均匀的分布在Map对应的数组位置的合理值
 *
 * @author Carlose wei
 * @version 1.0
 * @date 2020/4/20 14:38
 */
public class MyHashMap<K,V> implements MyMap<K,V>{
    //数组的默认初始化长度
    private static final int DEFAULT_INITIAL_CAPACITY = 1<<4;
    //阈值比例
    private static final float DEFAULT_LOAD_FACTOR = 0.75F;

    private int defaultInitSize;
    private float defaultLoadFactor;

    //Map中的entry数量
    private int entrySize;

    //数组
    private MyEntry<K,V>[] table = null;

    public MyHashMap(){
        this(DEFAULT_INITIAL_CAPACITY,DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int defaultInitSize, float defaultLoadFactor) {
        this.defaultInitSize = defaultInitSize;
        this.defaultLoadFactor = defaultLoadFactor;
        table = new MyEntry[this.defaultInitSize];
    }

    /**
     * 第一，要考虑是否扩容？
     *
     * HashMap中的Entry的数量（数组以及单链表中的所有Entry）是否达到阀值？
     *
     * 第二，如果扩容，意味着新生成一个Entry[]，不仅如此还得重新散列。
     *
     * 第三，要根据Key计算出在Entry[]中的位置，定位后，如果Entry[]中的元素为null，那么可以放入其中，如果不为空，那么得遍历单链表，要么更新value，要么形成一个新的Entry“挤压”单链表！
     *
     * @param k
     * @param v
     * @return
     */
    @Override
    public V put(K k, V v) {
        V oldValue = null;
        //是否需要扩容
        //扩容完毕，肯定需要重新散列
        if (entrySize >= defaultInitSize*defaultLoadFactor)
            resize(2*defaultInitSize);
        //得到HASH值，计算出数组中的位置
        int index = hash(k) & (defaultInitSize -1);//按位与  目的是为了取模，当n等于2的次幂时，"m%n"和"m&(n-1)"等价这就是为什么 桶的数量必须是2的次幂，为了方便取模
        if(table[index] == null){
            table[index] = new MyEntry<K,V>(k,v,null);
            ++entrySize;
        }else {//需要遍历单链表
            MyEntry<K,V> myEntry = table[index];
            MyEntry<K,V> e = myEntry;
            while (e != null){
                if (k == e.getKey() || k.equals(e.getKey())){
                    oldValue = e.getValue();
                    e.setValue(v);
                    return oldValue;
                }
                e = e.next;
            }
            table[index] = new MyEntry<K, V>(k,v,myEntry);
            ++entrySize;
        }
        return oldValue;
    }

    @Override
    public V get(K k) {
        int index = hash(k) & (defaultInitSize -1);
        if (table[index] == null){
            return null;
        }else {
            MyEntry<K,V> entry = table[index];
            do {
                if (k == entry.getKey() || k.equals(entry.getKey()))
                    return entry.getValue();
                entry = entry.next;
            }while (entry!=null);
        }
        return null;
    }

    //<<:左移运算符，num << 1,相当于num乘以2
    //>>:右移运算符，num >> 1,相当于num除以2
    //>>>:无符号右移，忽略符号位，空位都以0补齐
    private int hash(K k){//用原始的hashcode很容易产生hash碰撞
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);//该操作的目的是为了让原来的hashcode的每一位都对最终的取模结果产生了影响
    }

    private void resize(int i){
        MyEntry[] newTable = new MyEntry[i];
        defaultInitSize = i;
        entrySize = 0;
        rehash(newTable);
    }

    private void rehash(MyEntry<K,V>[] newTable){
        //得到原来老的Entry集合，注意遍历单链表
        List<MyEntry<K,V>> entryList = new ArrayList<MyEntry<K, V>>();
        for (MyEntry<K,V> entry : table){
            if (entry!=null){
                do{
                    entryList.add(entry);
                    entry = entry.next;
                }while (entry!=null);
            }
        }

        //覆盖旧的引用
        if (newTable.length > 0){
            table = newTable;
        }

        //所谓重新hash，就是重新put entry到hashmap
        for (MyEntry<K,V> entry:entryList){
            put(entry.getKey(),entry.getValue());
        }
    }
}
