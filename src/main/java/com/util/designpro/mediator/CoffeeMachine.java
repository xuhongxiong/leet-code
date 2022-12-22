package com.util.designpro.mediator;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class CoffeeMachine extends Colleague{
    public CoffeeMachine(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name,this);
    }

    public void startCoffee(){
        System.out.println("startCoffee");
    }

    public void finishCoffee(){
        System.out.println("finishCoffee");
        sendMessage(0);
    }

    @Override
    void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange,this.name);
    }
}
