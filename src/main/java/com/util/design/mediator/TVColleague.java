package com.util.design.mediator;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class TVColleague extends Colleague{
    public TVColleague(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name,this);
    }

    @Override
    void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange,this.getName());
    }

    void start(){
        System.out.println("电视开机");
    }
}
