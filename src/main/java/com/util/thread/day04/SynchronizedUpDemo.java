package com.util.thread.day04;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * 查询对象大小
 *
 * 偏向锁在JDK1.6以上默认开启,开启后程序启动几秒后才会被激活,可以使用JVM参数来关闭延迟 -XX:BiasedLockingStartupDelay=0
 * 如果关闭偏向锁,就可以直接进入轻量级锁 -XX:-UseBiasedLocking
 */
public class SynchronizedUpDemo {
    public static void main(String[] args) {
        noLock();
//        basicLock();
//        test4();
    }

    public static void test4(){
        Object o = new Object();
        new Thread(() -> {
            synchronized (o){
                System.out.println(ClassLayout.parseInstance(o).toPrintable());
            }
        },"t1").start();
        new Thread(() -> {
            synchronized (o){
                System.out.println(ClassLayout.parseInstance(o).toPrintable());
            }
        },"t2").start();
    }

    public static void basicLock(){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Object o = new Object();
        System.out.println("10进制："+o.hashCode());
        System.out.println("16进制："+Integer.toHexString(o.hashCode()));
        //10110 11110110 01010110 00010010
        //0010110 11110110 01010110 00010010
        System.out.println("2进制："+Integer.toBinaryString(o.hashCode()));
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        System.out.println("=======================");
        new Thread(() -> {
            synchronized (o){
                System.out.println(ClassLayout.parseInstance(o).toPrintable());
            }
        },"t1").start();
    }

    public static void noLock(){
        //锁消除
        SynchronizedUpDemo synchronizedUpDemo = new SynchronizedUpDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(synchronizedUpDemo::m1,String.valueOf(i)).start();
        }
    }
    static Object objectLock = new Object();
    public void m1(){
        Object o = new Object();
        //锁消除
        synchronized (o){
            System.out.println("o.hashCode："+o.hashCode()+"\t ObjectLock.hashCode："+objectLock.hashCode());
        }
    }
}
