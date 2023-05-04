package com.util.thread.Volatile;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 *  CAS的缺点
 * ①. 循环时间长开销很大
 * 我们可以看到getAndInt方法执行时,有个do while
 * 如果CAS失败,会一直进行尝试。如果CAS长时间一直不成功,可能会给CPU带来很大的开销
 * ②. 只能保证一个共享变量的原子性
 * 当对一个共享变量执行操作时,我们可以使用循环CAS的方式来保证原子操作
 * 对多个共享变量操作时,循环CAS就无法保证操作的原子性,这个时候就可以用锁来保证原子性
 *
 * ③. ABA问题的产生
 * (比如一个线程one从内存位置V中取出A,这时候另一个线程two也从内存中取出A,并且线程two进行了一些操作将值变成了B,然后线程two又将V位置的数据变成A,
 * 这时候线程one进行CAS操作发现内存中仍然是A,然后线程one操作成功。尽管线程one的CAS操作成功,但是不代表这个过程就是没问题的)
 */
public class ABADemo {
    public static AtomicInteger atomicInteger = new AtomicInteger(100);
    public static AtomicStampedReference<Integer> atomicReference = new AtomicStampedReference<>(100,1);
    public static void main(String[] args) {
        /*//ABA问题
        new Thread(new Runnable() {
            @Override
            public void run() {
                atomicInteger.compareAndSet(100,101);
                atomicInteger.compareAndSet(101,100);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(atomicInteger.get());*/

        //解决ABA问题
        new Thread(new Runnable() {
            @Override
            public void run() {
                int stamp = atomicReference.getStamp();
                System.out.println(Thread.currentThread().getName()+"第一次版本号："+stamp);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                atomicReference.compareAndSet(100,101,stamp,stamp+1);
                System.out.println(Thread.currentThread().getName()+"第二次版本号："+atomicReference.getStamp());
                atomicReference.compareAndSet(101,100,atomicReference.getStamp(),atomicReference.getStamp()+1);
                System.out.println(Thread.currentThread().getName()+"第三次版本号："+atomicReference.getStamp());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int stamp = atomicReference.getStamp();
                System.out.println(Thread.currentThread().getName()+"第一次版本号："+stamp);
                try {
                    //让前一个线程执行完
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                boolean result = atomicReference.compareAndSet(100, 2023, stamp, stamp + 1);
                System.out.println(Thread.currentThread().getName()+"result:"+result+"第二次版本号："+atomicReference.getStamp());
            }
        }).start();
    }
}
