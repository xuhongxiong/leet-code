package com.util.designpro.proxy;

public class CalculatorImpl implements Calculator{
    @Override
    public int add(int i, int j) {
        int result = i + j;
        System.out.println("方法内部 result = " + result);
        return result;
    }
}
