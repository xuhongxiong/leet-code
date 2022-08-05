package com.util.design.visitor;

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
public class ObjectStructure {
    private final List<Person> personList = new ArrayList<>();

    public void add(Person person){
        personList.add(person);
    }

    public void display(Action action){
        for (Person person : personList) {
            person.accept(action);
        }
    }
}
