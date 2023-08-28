package com.util.designpro.factory.simple;

/**
 * <p>Project: leet-code </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2023 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class SimpleFactory {
    public Pizza getPizza(String orderType){
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
}
