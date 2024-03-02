package com.util.thread.day04;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {

    static int number = 1     ;
    static StampedLock stampedLock = new StampedLock();
    public static void main(String[] args) {
        /*StampedLockDemo stampedLockDemo = new StampedLockDemo();
        new Thread(() -> {
            stampedLockDemo.read();
        },"read").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Thread(() -> {
            stampedLockDemo.write();
        },"write").start();
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+"\t result :"+number);*/

        StampedLockDemo stampedLockDemo = new StampedLockDemo();
        new Thread(() -> {
            stampedLockDemo.optimisticRead();
        },"read").start();
        try {
//            TimeUnit.SECONDS.sleep(2);
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Thread(() -> {
            stampedLockDemo.write();
        },"write").start();
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+"\t result :"+number);

    }

    public void write(){
        long stamp = stampedLock.writeLock();
        System.out.println(Thread.currentThread().getName()+"\t 写线程准备修改");
        try {
            number = number+1;
        }finally {
            stampedLock.unlockWrite(stamp);
        }
        System.out.println(Thread.currentThread().getName()+"\t 写线程结束");
    }

    //悲观读
    public void read(){
        long stamp = stampedLock.readLock();
        System.out.println(Thread.currentThread().getName()+"\t come in readlock, 4 seconds continue");
        for (int i = 0; i < 4; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"\t 正在读取中");
        }
        try {
            int result = number;
            System.out.println(Thread.currentThread().getName()+"\t result :"+result);
        }finally {
            stampedLock.unlockRead(stamp);
        }
    }

    //乐观读
    public void optimisticRead(){
        long stamp = stampedLock.tryOptimisticRead();
        int result = number;
        System.out.println(Thread.currentThread().getName()+"\t 4秒前 validate方法值（true无修改，false有修改）"+"\t"+stampedLock.validate(stamp));
        for (int i = 0; i < 4; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"\t 正在读取中 \t"+i+"\t"+stampedLock.validate(stamp));
        }
        if (!stampedLock.validate(stamp)){
            System.out.println(Thread.currentThread().getName()+"\t 有人修改--有写操作");
            stamp = stampedLock.readLock();
            try {
                System.out.println(Thread.currentThread().getName()+"\t 从乐观度升级为悲观读");
                result = number;
                System.out.println(Thread.currentThread().getName()+"\t 重新悲观读后result："+result);
            }finally {
                stampedLock.unlockRead(stamp);
            }
        }
    }
}
