package com.util.thread.object;

import java.util.concurrent.Semaphore;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2023 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName()+"抢占了线程");
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()+"释放了线程");
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        semaphore.release();
                    }
                }
            },String.valueOf(i)).start();
        }
    }
}
