package com.util.thread.Volatile;

/**
 * 验证volatile可见性，不能保证原子性
 */
public class UseVolatileDemo {
    private volatile static boolean flag = true;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag){
                    System.out.println("处理业务");
                }
            }
        }).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                flag = false;
            }
        }).start();
    }
}
