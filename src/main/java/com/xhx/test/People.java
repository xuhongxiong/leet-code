package com.xhx.test;

import java.math.BigDecimal;

public class People implements Cloneable{
    private BigDecimal id;
    private String name;
    private BigDecimal amount;
    private String pass;
    private int num;

    public People() {
    }

    public People(BigDecimal id, String name, BigDecimal amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public People(BigDecimal id, String name, BigDecimal amount, String pass) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", pass='" + pass + '\'' +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
