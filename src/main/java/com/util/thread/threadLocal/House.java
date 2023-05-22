package com.util.thread.threadLocal;

/**
 * ①. ThreadLocal本地线程变量,线程自带的变量副本
 * (实现了每一个线程副本都有一个专属的本地变量,主要解决的就是让每一个线程绑定自己的值,自己用自己的,不跟别人争抢。
 * 通过使用get()和set()方法,获取默认值或将其值更改为当前线程所存的副本的值从而避免了线程安全的问题)
 *
 * ②. synchronized或者lock,有个管理员,好比,现在大家签到,多个同学(线程),但是只有一只笔,只能同一个时间,只有一个线程(同学)签到,加锁(同步机制是以时间换空间,执行时间不一样,类似于排队)
 *
 * ③. ThreadLocal,人人有份,每个同学手上都有一支笔,自己用自己的,不用再加锁来维持秩序(同步机制是以空间换时间,为每一个线程都提供了一份变量的副本,从而实现同时访问,互不干扰同时访问,肯定效率高啊)
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
