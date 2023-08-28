package com.util.designpro.factory.method;

import com.util.designpro.factory.simple.Pizza;

/**
 * <p>Project: leet-code </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2023 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public abstract class OrderPizza {
    private String orderType;
    abstract Pizza createPizza(String orderType);
}
