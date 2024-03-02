package com.util.thread.day02;

import java.util.concurrent.TimeUnit;

public class VolatileSeeDemo {
    static boolean flag = true;
//    volatile static boolean flag = true;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"\t come in");
                while (flag){

                }
                System.out.println(Thread.currentThread().getName()+"\t flag被设置为false，程序停止");
            }
        },"t1").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        flag = false;
        System.out.println(Thread.currentThread().getName()+"\t 修改完成");
    }
}
