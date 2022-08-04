package com.util.spring.example;

import com.xhx.spring.ApplicationContext;
import com.xhx.spring.interfaceMstr.ComponentScan;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
@ComponentScan(basePackages = "com.xhx.spring.example")
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext(Main.class);
        Boy boy = (Boy) applicationContext.getBean("Boy");
        boy.driver();
        System.out.println();
    }
}
