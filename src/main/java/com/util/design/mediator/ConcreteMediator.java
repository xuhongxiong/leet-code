package com.util.design.mediator;

import java.util.HashMap;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class ConcreteMediator extends Mediator{
    private final HashMap<String, Colleague> colleagueMap;
    private final HashMap<String, String> interMap;

    public ConcreteMediator() {
        colleagueMap = new HashMap<>();
        interMap = new HashMap<>();
    }

    @Override
    void register(String colleagueName, Colleague colleague) {
        colleagueMap.put(colleagueName,colleague);
        if (colleague instanceof CoffeeColleague){
            interMap.put("coffee",colleagueName);
        } else if (colleague instanceof  TVColleague){
            interMap.put("tv",colleagueName);
        }
    }

    @Override
    void getMessage(int stateChange, String colleagueName) {
        Colleague colleague = colleagueMap.get(colleagueName);
        if (colleague instanceof CoffeeColleague){
            TVColleague tv = (TVColleague) colleagueMap.get(interMap.get("tv"));
            tv.start();
        }
    }

    @Override
    void senMessage() {

    }
}
