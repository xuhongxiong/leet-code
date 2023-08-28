package com.util.designpro.factory.method;

import com.util.designpro.factory.simple.ChinaPizza;
import com.util.designpro.factory.simple.GreekPizza;
import com.util.designpro.factory.simple.Pizza;

/**
 * <p>Project: leet-code </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2023 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class BjOrderPizza extends OrderPizza{

    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza;
        if ("greek".equals(orderType)){
            pizza = new GreekPizza();
        } else if ("china".equals(orderType)){
            pizza = new ChinaPizza();
        } else {
            pizza = null;
        }
        return pizza;
    }

    public static void main(String[] args) {
        BjOrderPizza orderPizza = new BjOrderPizza();
        Pizza pizza = orderPizza.createPizza("greek");
        pizza.prepare();
        pizza.bake();
    }
}
