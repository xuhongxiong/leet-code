package com.util.designpro.component;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class Department extends University{
    public Department(String name) {
        super(name);
    }

    @Override
    void print() {
        System.out.println(getName());
    }
}
