package com.aotuman.test.juc.me;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * TicketLock
 * TicketLock主要解决的是公平性的问题。
 *
 * 思路：每当有线程获取锁的时候，就给该线程分配一个递增的id，我们称之为排队号，
 * 同时，锁对应一个服务号，每当有线程释放锁，服务号就会递增，此时如果服务号与某个线程排队号一致，那么该线程就获得锁，
 * 由于排队号是递增的，所以就保证了最先请求获取锁的线程可以最先获取到锁，就实现了公平性。
 *
 * 可以想象成银行办理业务排队，排队的每一个顾客都代表一个需要请求锁的线程，而银行服务窗口表示锁，
 * 每当有窗口服务完成就把自己的服务号加一，此时在排队的所有顾客中，
 * 只有自己的排队号与服务号一致的才可以得到服务。
 */
public class TicketLock {
    /**
     * 服务号
     */
    private AtomicInteger serviceNum = new AtomicInteger();
    /**
     * 排队号
     */
    private AtomicInteger ticketNum = new AtomicInteger();
    /**
     * lock:获取锁，如果获取成功，返回当前线程的排队号，获取排队号用于释放锁. <br/>
     *
     * @return
     */
    public int lock() {
        int currentTicketNum = ticketNum.incrementAndGet();
        while (currentTicketNum != serviceNum.get()) {
            // Do nothing
        }
        return currentTicketNum;
    }
    /**
     * unlock:释放锁，传入当前持有锁的线程的排队号 <br/>
     *
     * @param ticketnum
     */
    public void unlock(int ticketnum) {
        serviceNum.compareAndSet(ticketnum, ticketnum + 1);
    }
}