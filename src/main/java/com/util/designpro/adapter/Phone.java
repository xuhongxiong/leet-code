package com.util.designpro.adapter;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class Phone {

    public void charging(Voltage5V voltage5V){
        int i = voltage5V.outPut5V();
        if (i == 5){
            System.out.println("充电成功");
        } else {
            System.out.println("充电失败");
        }
    }
}
