package com.util.designpro.component;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class Client {
    public static void main(String[] args) {
        University university = new University("清华大学");
        Department department1 = new Department("计算机学院");
        Department department2 = new Department("物理学院");
        university.add(department1);
        university.add(department2);
        university.print();
        university.remove(department1);
        System.out.println("-------------");
        university.print();
    }
}
