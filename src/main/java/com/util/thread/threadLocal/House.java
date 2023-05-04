package com.util.thread.threadLocal;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2023 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class House {
    ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    private void saleHouse(){
        Integer integer = threadLocal.get();
        integer++;
        threadLocal.set(integer);
    }

    public static void main(String[] args) {
        House house = new House();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //在阿里巴巴手册中有说明,尽量在代理中使用try-finally块进行回收
                try {
                    for (int i = 0; i < 3; i++) {
                        house.saleHouse();
                    }
                    System.out.println(Thread.currentThread().getName()+": "+house.threadLocal.get());
                }finally {
                    house.threadLocal.remove();
                    System.out.println("----------------"+house.threadLocal.get());
                }
            }
        },"t1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //在阿里巴巴手册中有说明,尽量在代理中使用try-finally块进行回收
                try {
                    for (int i = 0; i < 5; i++) {
                        house.saleHouse();
                    }
                    System.out.println(Thread.currentThread().getName()+": "+house.threadLocal.get());
                }finally {
                    house.threadLocal.remove();
                }
            }
        },"t2").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //在阿里巴巴手册中有说明,尽量在代理中使用try-finally块进行回收
                try {
                    for (int i = 0; i < 8; i++) {
                        house.saleHouse();
                    }
                    System.out.println(Thread.currentThread().getName()+": "+house.threadLocal.get());
                }finally {
                    house.threadLocal.remove();
                }
            }
        },"t3").start();
        System.out.println(Thread.currentThread().getName()+": "+house.threadLocal.get());
    }
}
