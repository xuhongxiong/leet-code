package com.util.spring.example;


import com.util.spring.interfaceMstr.Autowired;
import com.util.spring.interfaceMstr.Component;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
@Component
public class Boy {

    @Autowired
    private Car car;

    public void driver() {
        car.run();
    }
}
