package com.util.designpro.state;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 * 发放奖品的状态
 */
public class DispenseState extends State{
    private RaffleActivity activity;

    public DispenseState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("不能扣除积分");
    }

    @Override
    public boolean raffle() {
        System.out.println("不能抽奖");
        return false;
    }

    @Override
    public void dispensePrize() {
        if (activity.getCount() > 0){
            System.out.println("恭喜中奖");
            activity.setState(activity.getNoRaffleState());
        } else {
            System.out.println("奖品发放完了");
            activity.setState(activity.getDispenseOutState());
        }
    }
}
