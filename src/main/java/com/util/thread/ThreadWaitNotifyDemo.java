package com.util.thread;

/**
1.题目:
    现在两个线程,可以操作初始值为0的一个变量，实现一个线程对该变量加1,
    一个线程对该变量减1,交替执行,来10轮,变量的初始值为0
2.思想:
    1.在高内聚低耦合的前提下,线程->操作->资源类
    2.判断操作唤醒[生产消费中]
    3.多线程交互中,必须要放置多线程的虚假唤醒,也即(判断使用while,不能使用if)
* */
public class ThreadWaitNotifyDemo {

    public static void main(String[] args) {
        AirCondition airCondition = new AirCondition();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    airCondition.add();
                }
            }
        }, "线程A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    airCondition.subtract();
                }
            }
        }, "线程B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    airCondition.add();
                }
            }
        }, "线程C").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    airCondition.subtract();
                }
            }
        }, "线程D").start();
    }
}

class AirCondition {
    private int number = 0;
    public synchronized void add(){
        /**
         * 为什么不用if?解释如下
         * 第一次A进来了,在number++后(number=1) C抢到执行权,进入wait状态
         * 这个时候,A抢到cpu执行权,也进入wait状态,此时,B线程进行了一次消费
         * 唤醒了线程,这个时候A抢到CPU执行权,不需要做判断,number++(1),唤醒线程
         * C也抢到CPU执行权,不需要做判断,number++(2)
         *
         * 出现虚假唤醒的原因是从阻塞态到就绪态再到运行态没有进行判断，我们只需要让其每次得到操作权时都进行判断就可以了
         */
        while (number != 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number++;
        System.out.println(Thread.currentThread().getName()+":"+number);
        this.notifyAll();
    }

    public synchronized void subtract(){
        while (number == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number--;
        System.out.println(Thread.currentThread().getName()+":"+number);
        this.notifyAll();
    }
}
