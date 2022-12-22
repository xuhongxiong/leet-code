package com.util.designpro.handle;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class FirstApprover extends Approver{
    public FirstApprover(String name) {
        super(name);
    }

    @Override
    void processRequest(PurchaseRequest request) {
        int price = request.getPrice();
        if (price < 3000){
            System.out.println("已被FirstApprover处理");
        } else {
            approver.processRequest(request);
        }
    }
}
