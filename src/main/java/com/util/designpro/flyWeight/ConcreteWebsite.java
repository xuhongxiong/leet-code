package com.util.designpro.flyWeight;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class ConcreteWebsite extends Website{

    public ConcreteWebsite(String name) {
        super(name);
    }

    @Override
    void use(User user) {
        System.out.println(user.getName() + "---" + getWebName());
    }
}
