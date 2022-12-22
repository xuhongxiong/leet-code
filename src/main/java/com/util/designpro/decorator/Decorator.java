package com.util.designpro.decorator;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class Decorator extends Drink{
    private final Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public int getPrice(){
        return super.getPrice() + drink.getPrice();
    }

    @Override
    public String getDesc() {
        return super.getDesc() + drink.getDesc();
    }
}
