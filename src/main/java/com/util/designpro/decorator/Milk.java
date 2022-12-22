package com.util.designpro.decorator;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class Milk extends Decorator{
    public Milk(Drink drink) {
        super(drink);
        setPrice(2);
        setDesc("milk");
    }
}
