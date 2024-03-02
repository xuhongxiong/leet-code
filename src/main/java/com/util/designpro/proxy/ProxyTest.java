package com.util.designpro.proxy;

import org.junit.Test;

public class ProxyTest {

    @Test
    public void test(){
        Star star = new Star();
        Star proxy = (Star) ProxyFactory.getCGLibProxy(star);
        proxy.sing("sing");
        System.out.println("-----------------分割线------------------");
        proxy.dance();
    }

    @Test
    public void test2(){
        ProxyFactory factory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) factory.getJDKProxy();
        //创建好了代理对象,代理对象就可以执行被代理类实现的接口的方法；当通过代理类的对象发起对被重写的方法的调用时，都会转换为对调用处理器实现类中的invoke方法的调用，invoke方法中就可以对被代理类进行功能增强.
        proxy.add(1, 5);
    }
}
