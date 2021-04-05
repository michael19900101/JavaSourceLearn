package com.aotuman.test.juc.me;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 *
 * https://blog.csdn.net/weixin_33995481/article/details/88771814?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control&dist_request_id=&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control
 */
public class SpinLock {
    /**
     * 持有锁的线程，null表示锁未被线程持有
     */
    private AtomicReference<Thread> cas = new AtomicReference<>();


    /**
     * lock（)方法利用的CAS，当第一个线程A获取锁的时候，能够成功获取到，不会进入while循环，
     * 如果此时线程A没有释放锁，另一个线程B又来获取锁，此时由于不满足CAS，
     * 所以就会进入while循环，不断判断是否满足CAS，直到A线程调用unlock方法释放了该锁。
     */
    public void lock(){
        Thread currentThread = Thread.currentThread();
        // 利用CAS
        while (!cas.compareAndSet(null, currentThread)){
            //当ref为null的时候compareAndSet返回true，反之为false
            //通过循环不断的自旋判断锁是否被其他线程持有
        }
    }

    public void unLock() {
        Thread cur = Thread.currentThread();
        if (cas.get() != cur){
            //exception ...
        }
        cas.compareAndSet(cur,null);
    }

}
