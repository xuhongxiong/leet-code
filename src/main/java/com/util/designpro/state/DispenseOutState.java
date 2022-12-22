package com.util.designpro.state;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 * 奖品发放完毕
 */
public class DispenseOutState extends State{
    private RaffleActivity activity;

    public DispenseOutState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("奖品发放完毕，请下次抽奖");
    }

    @Override
    public boolean raffle() {
        System.out.println("奖品发放完毕，请下次抽奖");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("奖品发放完毕，请下次抽奖");
    }
}
