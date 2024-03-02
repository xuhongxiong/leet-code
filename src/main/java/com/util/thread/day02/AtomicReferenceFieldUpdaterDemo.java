package com.util.thread.day02;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class AtomicReferenceFieldUpdaterDemo {
    public static void main(String[] args) {
        MyCar myCar = new MyCar();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    myCar.Init(myCar);
                }
            },String.valueOf(i)).start();
        }
    }
}

class MyCar{
    public volatile Boolean isInit = false;

    AtomicReferenceFieldUpdater<MyCar,Boolean> fieldUpdater = AtomicReferenceFieldUpdater.newUpdater(MyCar.class,Boolean.class,"isInit");

    public void Init(MyCar myCar){
        if (fieldUpdater.compareAndSet(myCar,false,true)){
            System.out.println(Thread.currentThread().getName()+" start init");
        }
    }
}
