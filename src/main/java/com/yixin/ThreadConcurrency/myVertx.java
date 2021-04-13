package com.yixin.ThreadConcurrency;

import io.vertx.core.Future;
import org.junit.Test;

public class myVertx {
    private static void asynchronousMethod(Future<String> f){
        f.complete("haha");
    }

    public static void main(String[] args) {
        Future<String> future = Future.future();
        future.setHandler(r -> {
            System.out.println("result is:" + r);
        });
        asynchronousMethod(future);
    }

    @Test
    public void test(){
        Future<String> f1 = Future.future();
        Future<Integer> f2 = Future.future();

        f1.complete("f1's result");

        f1.compose(r -> {
            System.out.println("f1 handler:" + r);
            f2.complete(123);
        } , f2).setHandler(r -> {
            System.out.println("f2 handler:" + r.result());
        });
    }


    /**
     * 1.传入参数类型Function<T, Future<U>>,说明传入的是一个转换函数,此函数将future中的调用结果T转换为链中的下一个future.
     * 2.如果调用是成功的,那么将调用结果作为参数传入这个function执行,就是这句"apply = mapper.apply(ar.result());",返回结果为Future<U>.
     * 3.由于事先需要对调用结果ar是否成功判断,所以外面再套了个Future<U> ret.
     * 4.将ret返回.
     */
    @Test
    public void test1() throws Exception{
        Future<String> f1 = Future.future();
        f1.complete("f1's result");

        f1.compose(r -> {
            System.out.println(r);
            Future<String> f2 = Future.future();
            f2.complete("f2's result");
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return f2;
        }).compose(r -> {
            System.out.println(r);
            Future<String> f3 = Future.future();
            f3.complete("f3's result");
            return f3;
        }).setHandler(r -> {
            System.out.println(r.result());
        });
    }
}
