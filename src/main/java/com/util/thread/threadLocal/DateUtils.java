package com.util.thread.threadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  非线程安全的SimpleDateFormat
 *  ④. 源码分析结论(了解)
 * SimpleDateFormat类内部有一个Calendar对象引用,它用来储存和这个SimpleDateFormat相关的日期信息,例如sdf.parse(dateStr),
 * sdf.format(date) 诸如此类的方法参数传入的日期相关String,Date等等, 都是交由Calendar引用来储存的.
 * 这样就会导致一个问题如果你的SimpleDateFormat是个static的, 那么多个thread 之间就会共享这个SimpleDateFormat, 同时也是共享这个Calendar引用
 *
 * 将SimpleDateFormat定义成局部变量(方案一)
 * 加锁synchronized(方案二)
 * ThreadLocal 解决日期格式乱码问题(方案三)
 */
public class DateUtils {
    //public final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public final static ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    /*public synchronized static Date parse(String parseDate) throws Exception {
        return sdf.parse(parseDate);
    }*/
    public static Date parse(String parseDate) throws Exception {
        return threadLocal.get().parse(parseDate);
        //return sdf.parse(parseDate);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + ": " + DateUtils.parse("2020-11-11 11:11:11"));
                    } catch (Exception e) {
                        DateUtils.threadLocal.remove();
                        e.printStackTrace();
                    }
                }
            },String.valueOf(i)).start();
        }
    }
}
