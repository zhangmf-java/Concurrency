package com.imooc.concurrency.example.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class LockExample6 {

    //condition 协调线程的工具类

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        new Thread(() -> {
            try{
                reentrantLock.lock();
                log.info("wait signal"); //1
                condition.wait();//从AQS等待队列释放，及锁的释放， 进入condition等待队列中（AQS的第二个队列中）
            }catch (InterruptedException e){
                log.error("",e);
            }
            log.info("get signal"); //4
            reentrantLock.unlock();
        }).start();

        new Thread(() -> {
            reentrantLock.lock();
            log.info("get lock"); //2
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e){
                log.error("",e);
            }
            condition.signalAll();
            log.info("send signal ~ ");//3
            reentrantLock.unlock();
        }).start();

    }

}
