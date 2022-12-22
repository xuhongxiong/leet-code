package com.util.designpro.component;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public abstract class OrganizationComponent {

    private String name;

    public OrganizationComponent(String name) {
        this.name = name;
    }

    abstract void add(OrganizationComponent component);

    abstract void remove(OrganizationComponent component);

    abstract void print();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
