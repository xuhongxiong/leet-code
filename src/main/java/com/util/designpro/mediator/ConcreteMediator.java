package com.util.designpro.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class ConcreteMediator extends Mediator{
    private final Map<String,Colleague> map = new HashMap<>();

    @Override
    void register(String colleagueName, Colleague colleague) {
        map.put(colleagueName,colleague);
    }

    @Override
    void getMessage(int stateChange, String colleagueName) {
        if (map.get(colleagueName) instanceof Alarm){
            if (stateChange == 0){
                CoffeeMachine coffeeMachine = (CoffeeMachine)map.get("CoffeeMachine");
                coffeeMachine.startCoffee();
            }
        }
    }

    @Override
    void sendMessage() {

    }
}
