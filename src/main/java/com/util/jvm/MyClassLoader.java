package com.util.jvm;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * 重写loadClass方法（loadClass方法中有双亲委派机制）
 * 重写findClass方法（建议重写此方法）
 *
 */
public class MyClassLoader extends ClassLoader{
    private String rootDir;

    public MyClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    //name:com.util.jvm.user
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getClassData(name);
        if (classData != null){
            return defineClass(name,classData,0,classData.length);
        } else {
            throw new ClassNotFoundException();
        }
    }

    private byte[] getClassData(String className){
        String path = classNameToPath(className);
        InputStream ins = null;
        ByteArrayOutputStream bos = null;
        try {
            ins = new FileInputStream(path);
            bos = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int len;
            while ((len = ins.read(bytes)) != -1){
                bos.write(bytes,0, len);
            }
            return bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ins != null){
                    ins.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    //类文件完全路劲
    private String classNameToPath(String className){
        return rootDir + className.replace(".","\\") + ".class";
    }

    public static void main(String[] args) {
        String rootDir = "D:\\work\\workspace\\leet-code\\target\\classes\\";
        try {
            MyClassLoader myClassLoader1 = new MyClassLoader(rootDir);
            Class clazz1 = myClassLoader1.findClass("com.util.jvm.User");

            Class<?> clazz4 = myClassLoader1.loadClass("com.util.jvm.User");
            System.out.println(clazz4);
            System.out.println(clazz4.getClassLoader());
            System.out.println(clazz4.getClassLoader().getParent());
            Class<?> clazz5 = myClassLoader1.loadClass("com.util.jvm.User");
            System.out.println(clazz4 == clazz5);

            MyClassLoader myClassLoader2 = new MyClassLoader(rootDir);
            Class clazz2 = myClassLoader2.findClass("com.util.jvm.User");
            System.out.println(clazz1);
            System.out.println(clazz1 == clazz2);
            System.out.println(clazz1.getClassLoader());
            System.out.println(clazz2.getClassLoader());

            Class<?> clazz3 = ClassLoader.getSystemClassLoader().loadClass("com.util.jvm.User");
            System.out.println(clazz3.getClassLoader());
            System.out.println(clazz3.getClassLoader().getParent());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
