package com.util.thread.day04;

import com.util.thread.threadLocal.House;
import com.xhx.test.People;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * 关闭压缩：-XX:-UseCompressedClassPointers
 */
public class ObjectHeadDemo {
    public static void main(String[] args) {
        //Object object = new People();
        Object object = new Object();
        //System.out.println(object.hashCode());
        System.out.println(ClassLayout.parseInstance(object).toPrintable());
        //System.out.println(VM.current().details());
    }
}
