package com.util.designpro.state;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public abstract class State {

    //扣除积分-50
    public abstract void deductMoney();

    //是否抽中奖品
    public abstract boolean raffle();

    //发放奖品
    public abstract void dispensePrize();
}
