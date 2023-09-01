package com.xhx.exercise;

import org.junit.Test;

/**
 * <p>Project: leet-code </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2023 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class Test61 {
    @Test
    public void test(){
        System.out.println(waysToBuyPensPencils(20,10,5));
    }

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        int res = 0;
        for (int i = 0; i < total / cost1 + 1; i++) {
            int total2 = total-(cost1*i);
            res += (total2/cost2 + 1);
        }
        return res;
    }
}
