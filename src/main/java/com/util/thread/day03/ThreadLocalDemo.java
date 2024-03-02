package com.util.thread.day03;

public class ThreadLocalDemo {
    public static void main(String[] args) {
        House house = new House();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < 3; j++) {
                        house.saleHouse();
                    }
                    System.out.println(Thread.currentThread().getName()+"\t 卖出"+house.threadLocal.get());
                }finally {
                    //删除此线程局部变量的当前线程的值
                    //在阿里手册中有说明，尽量在try-finally块进行回收
                    house.threadLocal.remove();
                }
            },String.valueOf(i)).start();
        }
    }
}

class House{
    ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public void saleHouse(){
        threadLocal.set(threadLocal.get()+1);
    }
}
