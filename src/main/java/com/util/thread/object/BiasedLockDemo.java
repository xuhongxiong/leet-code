package com.util.thread.object;

import org.openjdk.jol.info.ClassLayout;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2023 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class BiasedLockDemo {
    public static void main(String[] args) {
        Object o = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    System.out.println(ClassLayout.parseInstance(o).toPrintable());
                }
            }
        },"t1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    System.out.println(ClassLayout.parseInstance(o).toPrintable());
                }
            }
        },"t2").start();
    }
}
