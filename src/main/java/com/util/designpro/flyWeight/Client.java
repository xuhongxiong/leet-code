package com.util.designpro.flyWeight;

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
        WebsiteFactory factory = new WebsiteFactory();
        Website website1 = factory.getWebsite("博客");
        website1.use(new User("小明"));
        Website website2 = factory.getWebsite("新闻");
        website2.use(new User("小红"));
        System.out.println(factory.getPoolSize());
    }
}
