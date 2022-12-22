package com.util.designpro.mediator;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public abstract class Mediator {
    abstract void register(String colleagueName, Colleague colleague);

    abstract void getMessage(int stateChange, String colleagueName);

    abstract void sendMessage();
}
