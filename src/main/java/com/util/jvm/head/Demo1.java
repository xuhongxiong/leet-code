package com.util.jvm.head;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Demo1 {
    public static void main(String[] args) {
        //强引用 不回收
        Object obj = new Object();
        //软引用 内存不足即回收 WeakHashMap软引用
        SoftReference<Object> obj1 = new SoftReference<>(obj);
        //弱引用 发现即回收
        WeakReference<Object> obj2 = new WeakReference<>(obj);
        //虚引用 对象回收跟踪
        ReferenceQueue<Object> phantomQueue = new ReferenceQueue<>();
        PhantomReference<Object> pf = new PhantomReference<>(obj, phantomQueue);
        obj = null;
    }
}
