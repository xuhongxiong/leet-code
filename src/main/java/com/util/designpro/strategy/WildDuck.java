package com.util.designpro.strategy;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class WildDuck extends Duck{
    @Override
    void display() {
        System.out.println("这是野鸭");
    }

    public WildDuck() {
        flyBehavior = new GoodsFly();
    }
}
