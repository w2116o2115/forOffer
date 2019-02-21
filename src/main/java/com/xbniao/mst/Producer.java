package com.xbniao.mst;

/**
 * @Author: Carlos Zhang
 * @Date: 2019/2/18 10:07
 */
public class Producer implements Runnable{
    private PublicBox box;

    public Producer(PublicBox box) {
        this.box = box;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            try {
                System.out.println("pro i:" + i);
                Thread.sleep(30);
            }catch (Exception e){
                e.printStackTrace();
            }
            box.increate();
        }
    }
}
