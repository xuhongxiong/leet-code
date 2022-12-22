package com.util.designpro.state;

import java.util.Random;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 * 可以抽奖的状态
 */
public class CanRaffleState extends State{

    private RaffleActivity activity;

    public CanRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("已经抽取过积分");
    }

    @Override
    public boolean raffle() {
        System.out.println("正在抽奖");
        Random random = new Random();
        int i = random.nextInt(10);
        if (i == 0){
            System.out.println("中奖");
            activity.setState(activity.getDispenseState());
            return true;
        } else {
            System.out.println("没有中奖");
            activity.setState(activity.getNoRaffleState());
            return false;
        }
    }

    @Override
    public void dispensePrize() {
        System.out.println("未中奖，不能发放奖品");
    }
}
