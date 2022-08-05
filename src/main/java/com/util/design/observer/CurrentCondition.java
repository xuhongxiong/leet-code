package com.util.design.observer;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class CurrentCondition implements Observer{
    private int value;

    @Override
    public void update(int value) {
        this.value = value;
        display();
    }

    public void display(){
        System.out.println(value);
    }
}
