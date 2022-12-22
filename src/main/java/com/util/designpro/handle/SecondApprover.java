package com.util.designpro.handle;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class SecondApprover extends Approver{
    public SecondApprover(String name) {
        super(name);
    }

    @Override
    void processRequest(PurchaseRequest request) {
        System.out.println("已被SecondApprover处理");
    }
}
