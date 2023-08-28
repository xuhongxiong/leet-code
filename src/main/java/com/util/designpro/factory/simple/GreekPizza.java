package com.util.designpro.factory.simple;

/**
 * <p>Project: leet-code </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2023 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class GreekPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("Greek prepare");
    }

    @Override
    public void bake() {
        System.out.println("Greek bake");
    }
}
