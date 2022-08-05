package com.util.design.component;

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
        OrganizationComponent university = new University("清华", "aaa");
        OrganizationComponent college = new College("计算机","bbb");
        OrganizationComponent college1 = new College("土木","bbb");
        OrganizationComponent college2 = new College("土木a","bbbaaa");
        college.add(new Department("计科","ccc"));
        college.add(new Department("计科1","ccc"));
        college1.add(new Department("土木1","ccc"));
        university.add(college);
        university.add(college1);
        university.add(college2);
        university.print();
    }
}
