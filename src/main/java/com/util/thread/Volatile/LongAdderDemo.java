package com.util.thread.Volatile;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.LongBinaryOperator;

/**
 *  ②. LongAdder在无竞争的情况,跟AtomicLong一样,对同一个base进行操作,
 *   当出现竞争关系时则采用化整为零的做法,从空间换时间,用一个数组cells,将一
 *   个value拆分进这个数组cells。多个线程需要同时对value进行操作时候,可以
 *   对线程id进行hash得到hash值,再根据hash值映射到这个数组cells的某个下标,
 *   再对该下标所对应的值进行自增操作。当所有线程操作完毕,将数组cells的所有值
 *   和无竞争值base都加起来作为最终结果(分散热点)
 *
 *   LongAdder只能用来计算加法、减法,且从零开始计算
 *   LongAccumulator提供了自定义的函数操作
 */
public class LongAdderDemo {
    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        longAdder.increment();
        longAdder.increment();
        longAdder.decrement();
        System.out.println(longAdder.sum());
        System.out.println(longAdder.longValue());

        LongAccumulator longAccumulator = new LongAccumulator(new LongBinaryOperator() {
            @Override
            public long applyAsLong(long left, long right) {
                return left * right;
            }
        }, 2);
        longAccumulator.accumulate(2);
        longAccumulator.accumulate(2);
        System.out.println(longAccumulator.get());
        System.out.println(longAccumulator.longValue());
    }
}
