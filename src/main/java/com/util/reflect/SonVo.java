package com.util.reflect;

import com.xhx.test.People;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>Project: leet-code </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class SonVo {
    private BigDecimal age;
    private String name;
    private List<String> stringList;
    private List<People> peopleList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<People> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<People> peopleList) {
        this.peopleList = peopleList;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }
}
