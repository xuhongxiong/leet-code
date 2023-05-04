package com.util.thread;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class Test3 {

    public static void main(String[] args) {
        Object lock = new Object();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        for (int i = 0; i < 10; i++) {
                            //Thread.sleep(80);
                            if (i == 5){
                                //Thread.yield();
                            }
                            System.out.println(Thread.currentThread().getName() + i);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        },"thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    for (int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName() + i);
                    }
                }
            }
        },"thread2");

        try {
            thread1.start();
            //Thread.sleep(100);
            thread2.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
