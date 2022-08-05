package com.util.design.decorate;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class Decorator extends Drink{
    private Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    int cost() {
        return super.getPrice()+drink.cost();
    }

    @Override
    public String getDesc() {
//        return super.getDesc();
        return super.getDesc() + getPrice() + "&&" + drink.getDesc();
    }
}
