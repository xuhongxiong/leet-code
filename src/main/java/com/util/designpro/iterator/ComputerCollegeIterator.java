package com.util.designpro.iterator;

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
public class ComputerCollegeIterator implements Iterator<String>{
    List<String> departments;
    int position = 0;

    public ComputerCollegeIterator(List<String> departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if (position >= departments.size() || departments.get(position) == null){
            return false;
        }
        return true;
    }

    @Override
    public String next() {
        String str = departments.get(position);
        position++;
        return str;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}
