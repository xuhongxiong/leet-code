package com.util.designpro.component;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class University extends OrganizationComponent{

    private final List<OrganizationComponent> organizationComponentList = new ArrayList<>();

    public University(String name) {
        super(name);
    }

    @Override
    void add(OrganizationComponent component) {
        organizationComponentList.add(component);
    }

    @Override
    void remove(OrganizationComponent component) {
        organizationComponentList.remove(component);
    }

    @Override
    void print() {
        System.out.println(getName());
        for (OrganizationComponent organizationComponent : organizationComponentList) {
            organizationComponent.print();
        }
    }
}
