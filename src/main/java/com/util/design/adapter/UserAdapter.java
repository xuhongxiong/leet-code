package com.util.design.adapter;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class UserAdapter implements IUserService{
    @Override
    public void insert() {
        System.out.println(2222);
    }

    @Override
    public void update() {
        System.out.println(333);
    }
}
