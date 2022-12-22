package com.util.designpro.director;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class CommonHouse extends HouseBuilder {
    @Override
    void buildPartA(Product product) {
        System.out.println(product.getWall());
        System.out.println("common,第一步");
    }

    @Override
    void buildPartB() {
        System.out.println("common,第二步");
    }

    @Override
    void build() {
        Product product = new Product();
        product.setWall("common wall");
        buildPartA(product);
        buildPartB();
    }
}
