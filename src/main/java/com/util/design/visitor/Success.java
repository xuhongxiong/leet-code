package com.util.design.visitor;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class Success extends Action{
    @Override
    void getManResult(Man man) {
        System.out.println("man成功");
    }

    @Override
    void getManResult(Woman woman) {
        System.out.println("woman成功");
    }
}
