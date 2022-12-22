package com.util.designpro.flyWeight;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class WebsiteFactory {
    private final static Map<String, ConcreteWebsite> pool = new HashMap<>();

    public Website getWebsite(String type){
        ConcreteWebsite website = pool.get(type);
        if (website == null){
            website = new ConcreteWebsite(type);
            pool.put(type,website);
        }
        return website;
    }

    public int getPoolSize(){
        return pool.size();
    }
}
