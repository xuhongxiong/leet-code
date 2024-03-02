package com.util.thread.day03;

import java.lang.ref.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReferenceDemo {
    public static void main(String[] args) {
        //strongReference();
        //softReference(); -Xms10m -Xmx10m
        //weakReference();
        phantomReference();
    }
    private static void phantomReference() {
        MyObject obj = new MyObject();
        ReferenceQueue<MyObject> referenceQueue = new ReferenceQueue<>();
        PhantomReference<MyObject> phantomReference = new PhantomReference<>(obj,referenceQueue);
        //System.out.println(phantomReference.get());//null
        List<byte[]> list = new ArrayList<>();
        new Thread(() -> {
            while (true){
                list.add(new byte[1024 * 1024]);
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(phantomReference.get()+ "\t" + "list add ok");
            }
        },"t1").start();
        new Thread(() -> {
            while (true){
                Reference<? extends MyObject> reference = referenceQueue.poll();
                if (reference != null){
                    System.out.println("---有虚对象回收加入了队列");
                    break;
                }
            }
        },"t2").start();
    }
    private static void weakReference() {
        WeakReference<MyObject> weakReference = new WeakReference<>(new MyObject());
        System.out.println("gc before" + weakReference.get());
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("gc after" + weakReference.get());
    }
    private static void softReference() {
        SoftReference<MyObject> softReference = new SoftReference<>(new MyObject());
        System.out.println("gc before" + softReference.get());
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            Byte[] bytes = new Byte[20 * 1024 * 1024];
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("内存不够用 gc after" + softReference.get());
        }

        System.out.println("gc after" + softReference.get());
    }

    private static void strongReference() {
        MyObject object = new MyObject();
        System.out.println("gc before" + object);
        object = null;
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("gc after" + object);
    }
}

class MyObject{
    //虚引用需注解掉
    /*@Override
    protected void finalize() throws Throwable {
        System.out.println("invoke finalize method");
    }*/
}
