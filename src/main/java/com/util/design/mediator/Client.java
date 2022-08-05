package com.util.design.mediator;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class Client {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        CoffeeColleague coffee = new CoffeeColleague(mediator, "coffee");
        TVColleague tv = new TVColleague(mediator, "tv");
        mediator.register("coffee",coffee);
        mediator.register("tv",tv);
        coffee.sendMessage(1);
    }
}
