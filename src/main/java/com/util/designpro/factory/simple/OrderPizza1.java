package com.util.designpro.factory.simple;

/**
 * <p>Project: leet-code </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2023 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class OrderPizza1 {
    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();
        Pizza pizza = factory.getPizza("china");
        pizza.prepare();
        pizza.bake();
    }
}
