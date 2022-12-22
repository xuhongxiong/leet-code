package com.util.designpro.decorator;

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
        ShortBlack shortBlack = new ShortBlack();
        System.out.println(shortBlack.getDesc());
        System.out.println(shortBlack.getPrice());
        Milk milk = new Milk(shortBlack);
        System.out.println(milk.getDesc());
        System.out.println(milk.getPrice());
    }
}
