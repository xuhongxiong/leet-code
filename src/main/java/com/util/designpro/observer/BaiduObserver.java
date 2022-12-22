package com.util.designpro.observer;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class BaiduObserver implements Observer{
    private String name;
    @Override
    public void update(String name) {
        this.name = name;
    }
    public void display(){
        System.out.println(name);
    }
}
