package com.util.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 *
 * 核心类
 */
public class WeatherData implements Subject{
    private int value;
    private List<Observer> observerList = new ArrayList<>();

    public void setData(int value){
        this.value = value;
        dataChange();
    }

    public void dataChange(){
        notifyObserver();
    }

    @Override
    public void register(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.update(this.value);
        }
    }
}
