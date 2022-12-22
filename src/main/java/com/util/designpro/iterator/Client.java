package com.util.designpro.iterator;

import java.util.Iterator;

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
        ComputerCollege computerCollege = new ComputerCollege();
        computerCollege.addDepartment("1");
        computerCollege.addDepartment("2");
        computerCollege.addDepartment("3");
        Iterator iterator = computerCollege.createIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
