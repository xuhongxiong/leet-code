package com.util.designpro.bridge;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class Phone {
    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    public void call(){
        brand.call();
    }
}
