package com.util.designpro.handle;

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
        FirstApprover first = new FirstApprover("first");
        SecondApprover second = new SecondApprover("second");
        first.setApprover(second);
        first.processRequest(new PurchaseRequest(2000));
        first.processRequest(new PurchaseRequest(5000));
    }
}
