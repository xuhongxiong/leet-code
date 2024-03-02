package com.util.thread.day01;

public class Test1 {
    public static void main(String[] args) {
        Thread.currentThread().getThreadGroup().list();
        System.out.println("======");
        System.out.println(Thread.activeCount());

        Student student = new Student();
        student.setId(1).setName("1");
    }
}
