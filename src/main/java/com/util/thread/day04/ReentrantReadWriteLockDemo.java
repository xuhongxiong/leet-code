package com.util.thread.day04;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {

    static String KEY = "key:";
    static String VALUE = "value:";
    public static void main(String[] args) {
        MyResource myResource = new MyResource();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                myResource.set(finalI+"",finalI+"");
            },String.valueOf(i)).start();
        }
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                myResource.get(finalI+"");
            },String.valueOf(i)).start();
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(() -> {
                myResource.set(finalI+"",finalI+"");
            },"新写锁线程"+i).start();
        }
    }
}

class MyResource{
    Map<String, String> map = new HashMap<>();
    Lock lock = new ReentrantLock();
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void set(String key,String value){
        //lock.lock();
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在写入");
            map.put(key,value);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"\t 完成写入");
        }finally {
            //lock.unlock();
            readWriteLock.writeLock().unlock();
        }
    }

    public String get(String key){
        //lock.lock();
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在读取");
            String value = map.get(key);
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"\t 完成读取"+"\t"+value);
            return value;
        }finally {
            //lock.unlock();
            readWriteLock.readLock().unlock();
        }
    }
}
