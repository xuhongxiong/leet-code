package com.util.designpro.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * cglib动态代理：通过继承被代理的目标类实现代理，所以不需要目标类实现接口。CGLIB通过动态生成一个需要被代理类的子类（即被代理类作为父类），
 * 该子类重写被代理类的所有不是final修饰的方法，并在子类中采用方法拦截的基数拦截父类所有的方法调用，进而织入横切逻辑（认干爹模式）
 *
 * jdk动态代理：要求必须有接口，最终生成的代理类和目标类实现相同的接口，在com.sun.proxy包下，类名为$proxy+数字（例如：$proxy6）
 *          JDK原生的实现方式，需要被代理的目标类必须实现接口。因为这个技术要求代理对象和目标对象实现同样的接口（两个兄弟拜把子模式）
 */
public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public static Object getCGLibProxy(final Object target){
        Object proxy = Enhancer.create(target.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object result = null;
                try {
                    System.out.println("[动态代理][日志]"+method.getName()+"，参数"+ Arrays.toString(objects));
                    result = method.invoke(target,objects);
                    System.out.println("[动态代理][日志]"+method.getName()+"，结果"+ result);
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("[动态代理][日志]"+method.getName()+"，异常"+ e.getMessage());
                }finally {
                    System.out.println("[动态代理][日志] " + method.getName() + "，方法执行完毕");
                }
                return result;
            }
        });
        return proxy;
    }

    public Object getJDKProxy(){
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    System.out.println("[动态代理][日志] " + method.getName() + "，参数" + Arrays.toString(args));
                    result = method.invoke(target, args);
                    System.out.println("[动态代理][日志] " + method.getName() + "，结果" + result);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("[动态代理][日志] " + method.getName() + "，异常：" + e.getMessage());
                } finally {
                    System.out.println("[动态代理][日志] " + method.getName() + "，方法执行完毕");
                }
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
    }
}
