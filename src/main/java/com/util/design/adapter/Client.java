package com.util.design.adapter;

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
        /*UserAdapter userAdapter = new UserAdapter(){
            @Override
            public void insert() {
                System.out.println("1111");
                //super.insert();
            }
        };
        userAdapter.insert();*/
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter(new Voltage220V()));
    }
}
