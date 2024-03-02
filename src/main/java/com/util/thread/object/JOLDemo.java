package com.util.thread.object;

import org.openjdk.jol.info.ClassLayout;

/**
 * 查询对象大小
 *
 * 偏向锁在JDK1.6以上默认开启,开启后程序启动几秒后才会被激活,可以使用JVM参数来关闭延迟 -XX:BiasedLockingStartupDelay=0
 * 如果关闭偏向锁,就可以直接进入轻量级锁 -XX:-UseBiasedLocking
 */
public class JOLDemo {
    public static void main(String[] args) {
        /*Object o = new Object();
        System.out.println(ClassLayout.parseInstance(new Object()).toPrintable());
        System.out.println(ClassLayout.parseInstance(new People()).toPrintable());*/

        /*Object o = new Object();
        System.out.println("10进制hash码:"+o.hashCode());
        System.out.println("16进制hash码:"+Integer.toHexString(o.hashCode()));
        System.out.println("2进制hash码:"+Integer.toBinaryString(o.hashCode()));
        System.out.println( ClassLayout.parseInstance(o).toPrintable());*/
        Object o = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    System.out.println(ClassLayout.parseInstance(o).toPrintable());
                }
            }
        },"t1").start();
    }
}
