package com.util.design.visitor;

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
        Man man = new Man();
        Woman woman = new Woman();
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.add(man);
        objectStructure.add(woman);
        Success success = new Success();
        objectStructure.display(success);
    }
}
