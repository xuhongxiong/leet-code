package com.util.thread.day02;

import com.util.thread.day01.Student;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.*;

public class AtomicDemo {
    public static void main(String[] args) {
        //int[] arr = {1,2};
        //AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arr);

        //AtomicInteger atomicInteger = new AtomicInteger();

        /*AtomicMarkableReference<Integer> markableReference = new AtomicMarkableReference<>(100,false);
        boolean marked = markableReference.isMarked();
        System.out.println(marked);
        markableReference.compareAndSet(100,101,marked,!marked);
        System.out.println(markableReference.getReference());*/

        AtomicIntegerFieldUpdater();
    }

    public static void AtomicIntegerFieldUpdater(){
        BankAccount bankAccount = new BankAccount();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    bankAccount.transMoney(bankAccount);
                }
                countDownLatch.countDown();
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(bankAccount.money);
    }
}

class BankAccount{
    String name = "CCB";
    public volatile int money = 0;

    public void add(){
        money++;
    }

    AtomicIntegerFieldUpdater<BankAccount> fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(BankAccount.class,"money");

    //不加synchronized，保证原子性
    public void transMoney(BankAccount bankAccount){
        fieldUpdater.getAndIncrement(bankAccount);
    }
}
