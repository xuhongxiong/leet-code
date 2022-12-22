package com.util.designpro.template;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public abstract class SoyaMilk {
    final void make() {
        select();
        add();
    }

    void select() {
        System.out.println("加入黄豆");
    };

    abstract void add();
}
