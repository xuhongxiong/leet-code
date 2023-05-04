package com.util.thread;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class Test1 {
    //boolean flag = true;
    volatile boolean flag = true;

    void update(){
        flag = false;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        new Thread(() -> {
            while (test1.flag){
                System.out.println("aaa");
            }
            System.out.println(Thread.currentThread().getName()+"结束");
        },"thread1").start();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                test1.update();
                System.out.println(Thread.currentThread().getName()+"结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"thread2").start();
        new Thread(() -> {
            while (test1.flag){
                System.out.println("bbb");
            }
            System.out.println(Thread.currentThread().getName()+"结束");
        },"thread3").start();
    }
}
