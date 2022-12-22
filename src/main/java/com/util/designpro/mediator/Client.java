package com.util.designpro.mediator;

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
        ConcreteMediator concreteMediator = new ConcreteMediator();
        Alarm alarm = new Alarm(concreteMediator, "Alarm");
        CoffeeMachine coffeeMachine = new CoffeeMachine(concreteMediator, "CoffeeMachine");
        alarm.sendAlarm(0);
        coffeeMachine.finishCoffee();
    }
}
