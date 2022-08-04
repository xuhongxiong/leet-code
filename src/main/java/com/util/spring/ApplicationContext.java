package com.util.spring;


import com.util.spring.interfaceMstr.Autowired;
import com.util.spring.interfaceMstr.Component;
import com.util.spring.interfaceMstr.ComponentScan;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class ApplicationContext {

    //存放类信息
    private final Map<String, Class<?>> classMap = new ConcurrentHashMap<>(16);
    //存放bean
    private final Map<String, Object> beanMap = new ConcurrentHashMap<>(16);

    public ApplicationContext(Class<?> configClass) {
        // 1.扫描配置信息中指定包下的类
        this.scan(configClass);
        // 2.实例化扫描到的类
        this.instantiateBean();
    }

    private void scan(Class<?> configClass) {
        //获取扫描包
        String basePackages = this.getBasePackages(configClass);
        //文件遍历
        this.doScan(basePackages);
    }

    private String getBasePackages(Class<?> configClass) {
        ComponentScan annotation = configClass.getAnnotation(ComponentScan.class);
        return annotation.basePackages();
    }

    private void doScan(String basePackages) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        String packagePath = basePackages.replace(".", "/");

        URL url = loader.getResource(packagePath);
        assert url != null;
        File dir = new File(url.getPath());
        for (File file : dir.listFiles()) {

            if (file.isDirectory()) {
                // 递归扫描
                doScan(basePackages + "." + file.getName());
            } else {
                // com.my.spring.example + . + Boy.class -> com.my.spring.example.Boy
                String className = basePackages + "." + file.getName().replace(".class", "");
                // 将class存放到classMap中
                this.registerClass(className);
            }
        }

    }

    private void registerClass(String className){
        try {
            // 加载类信息
            Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass(className);
            // 判断是否标识Component注解
            if(clazz.isAnnotationPresent(Component.class)){
                // 生成beanName com.my.spring.example.Boy -> boy
                String beanName = this.generateBeanName(clazz);
                // car: com.my.spring.example.Car
                classMap.put(beanName, clazz);
            }
        } catch (ClassNotFoundException ignore) {}
    }

    private String generateBeanName(Class<?> clazz) {
        String className = clazz.getName();
        String[] split = className.split("\\.");
        return split[split.length-1];
    }

    private void instantiateBean() {
        for (Map.Entry<String, Class<?>> entry : classMap.entrySet()){
            getBean(entry.getKey());
        }
    }

    public Object getBean(String beanName) {
        Object bean = beanMap.get(beanName);
        if (bean != null){
            return bean;
        }
        return this.createBean(beanName);
    }

    private Object createBean(String beanName) {
        Class<?> clazz = classMap.get(beanName);
        try {
            Object bean = this.doCreateBean(clazz);
            //将bean放入容器
            beanMap.put(beanName,bean);
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private Object doCreateBean(Class<?> clazz) throws Exception{
        //实例化bean
        Object bean = this.newInstance(clazz);
        //填充字段
        this.populateBean(bean,clazz);
        return bean;
    }

    private Object newInstance(Class<?> clazz) throws Exception {
        return clazz.getDeclaredConstructor().newInstance();
    }

    private void populateBean(Object bean, Class<?> clazz) throws Exception{
        // 解析class信息，判断类中是否有需要进行依赖注入的字段
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Autowired annotation = field.getAnnotation(Autowired.class);
            if (annotation != null){
                // 获取bean
                Object value = this.resolveBean(field.getType());
                field.setAccessible(true);
                field.set(bean,value);
            }
        }
    }

    private Object resolveBean(Class<?> clazz) {
        if (clazz.isInterface()){
            for (Map.Entry<String, Class<?>> entry : classMap.entrySet()){
                // 暂时只支持classMap只有一个子类的情况
                if (clazz.isAssignableFrom(entry.getValue())){
                    return getBean(entry.getValue());
                }
            }
            throw new RuntimeException("找不到可以进行依赖注入的bean");
        } else {
            return getBean(clazz);
        }
    }

    public Object getBean(Class<?> clazz) {
        // 生成bean的名称
        String beanName = this.generateBeanName(clazz);
        // 此处对应最开始的getBean方法
        return this.getBean(beanName);
    }
}
