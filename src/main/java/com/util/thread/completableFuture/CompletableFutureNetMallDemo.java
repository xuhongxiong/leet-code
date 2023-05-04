package com.util.thread.completableFuture;

import com.xhx.test.People;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 异步实际运用
 */
public class CompletableFutureNetMallDemo {
    public static void main(String[] args) {
        List<People> peopleList = new ArrayList<>();
        peopleList.add(new People());
        peopleList.add(new People());
        peopleList.add(new People());
        long start = System.currentTimeMillis();
        List<Integer> collect = peopleList.stream().map(o -> {
            Integer price = Mall.getPrice();
            return price;
        }).collect(Collectors.toList());
        long mid = System.currentTimeMillis();
        System.out.println("11:"+(mid-start));
        List<Integer> collect1 = peopleList.stream().map(o -> {
            CompletableFuture<Integer> integerCompletableFuture = null;
            try {
                integerCompletableFuture = CompletableFuture.supplyAsync(new Supplier<Integer>() {
                    @Override
                    public Integer get() {
                        Integer price = Mall.getPrice();
                        return price;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
            return integerCompletableFuture;
        }).collect(Collectors.toList()).stream().map(CompletableFuture::join).collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println("22:"+(end-mid));
    }
}

class Mall {
    public static Integer getPrice(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println(1);
        return 1;
    }
}
