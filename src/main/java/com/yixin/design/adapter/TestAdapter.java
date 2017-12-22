package com.yixin.design.adapter;

/**
 * http://blog.csdn.net/zhangjg_blog/article/details/18735243
 * 它的主要作用是在新接口和老接口之间进行适配
 */
public class TestAdapter {

    public static void main(String[] args) {

        GBSocketInterface gbSocket = new GBSocket();

        Hotel hotel = new Hotel();

        SocketAdapter socketAdapter = new SocketAdapter(gbSocket);

        hotel.setSocket(socketAdapter);

        hotel.charge();
    }
}