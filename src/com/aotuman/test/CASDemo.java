package com.aotuman.test;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {

    public static void main(String[] args) {
        // 原始值为5
        AtomicInteger atomicInteger = new AtomicInteger(5);
        // 因为原始值和期望值相等，则更新值为 2019
        System.out.println(atomicInteger.compareAndSet(5, 2019) + " current data :" +atomicInteger.get());
        // 由于上述已经将值改为2019，所以与期望值比较不相等，不能更新值
        System.out.println(atomicInteger.compareAndSet(5, 20124) + " current data :" +atomicInteger.get());
        // 获取最后修改成功的值
        System.out.println(atomicInteger.getAndIncrement());
    }
}
