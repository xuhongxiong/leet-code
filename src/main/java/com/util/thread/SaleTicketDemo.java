package com.util.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2023 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class SaleTicketDemo {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    ticket.sale();
                }
            }
        },"线程A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    ticket.sale();
                }
            }
        },"线程B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    ticket.sale();
                }
            }
        },"线程C").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    ticket.sale();
                }
            }
        },"线程D").start();
    }
}

class Ticket {

    private int number = 50;
    private final Lock lock = new ReentrantLock(true);
    //synchronized
    /*public synchronized void sale(){
        if (number > 0){
            System.out.println(Thread.currentThread().getName()+"\t 卖出第"+(number--)+"\t 还剩下"+number);
        }
    }*/

    public void sale(){
        lock.lock();
        try {
            if (number > 0){
                System.out.println(Thread.currentThread().getName()+"\t 卖出第"+(number--)+"\t 还剩下"+number);
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
