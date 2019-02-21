package com.xbniao.mst;

/**
 * @Author: Carlos Zhang
 * @Date: 2019/2/18 10:17
 */
public class Consumer implements Runnable{
    private PublicBox box;

    public Consumer(PublicBox box) {
        this.box = box;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            try{
                Thread.sleep(3000);// 这里设置跟上面30不同是为了 盒子中的苹果能够增加，不会生产一个马上被消费
            }catch (Exception e){
                e.printStackTrace();
            }
            box.decCreate();
        }
    }
}
