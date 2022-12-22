package com.util.designpro.observer;

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
        WeatherData weatherData = new WeatherData();
        weatherData.setDate("111");
        BaiduObserver baiduObserver = new BaiduObserver();
        weatherData.registerObserver(baiduObserver);
        weatherData.notifyObserver();
        baiduObserver.display();
    }
}
