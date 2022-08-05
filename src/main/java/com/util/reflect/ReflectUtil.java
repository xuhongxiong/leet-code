package com.util.reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>Project: leet-code </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class ReflectUtil {

    @Test
    public void test() throws Exception{
        Son son = new Son();
        SonVo sonVo = new SonVo();
        sonVo.setAge(new BigDecimal(1));
        setValue(son,sonVo,null);
        System.out.println(son.getAge());
    }

    private <T,K>void setValue(T father, K sonVo, List<String> includeFields) throws Exception {

        Class<?> aClass = father.getClass();
        Field[] fields = aClass.getDeclaredFields();
        Class<?> sonVoClass = sonVo.getClass();
        Field[] declaredFields = sonVoClass.getDeclaredFields();
        Set<String> voFields = new HashSet<>();
        for (Field declaredField : declaredFields) {
            voFields.add(declaredField.getName());
        }
        for (Field declaredField : fields) {
            String attributeName = declaredField.getName();
            //Method m = sonVoClass.getMethod("get" + firstUpperCase(attributeName));
            //todo 注解操作
            if (voFields.contains(attributeName)){
                //Object value = m.invoke(sonVo);
                Field voField = sonVoClass.getDeclaredField(attributeName);
                voField.setAccessible(true);
                Object value = voField.get(sonVo);
                declaredField.setAccessible(true);
                declaredField.set(father,value);
            }
        }
    }

    public static String firstUpperCase(String str) {
        return str.replaceFirst(str.substring(0, 1), str.substring(0, 1).toUpperCase());
    }
}
