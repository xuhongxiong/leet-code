package com.util.designpro.strategy;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public abstract class Duck {
    FlyBehavior flyBehavior = null;

    abstract void display();//显示鸭子信息
    public void swim(){
        System.out.println("鸭子会游泳");
    }

    public void fly(){
        if (flyBehavior != null){
            flyBehavior.fly();
        }
    }

    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}
