package com.util.designpro.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class ComputerCollege implements College{
    private final List<String> departments = new ArrayList<>();
    @Override
    public void addDepartment(String name) {
        departments.add(name);
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
