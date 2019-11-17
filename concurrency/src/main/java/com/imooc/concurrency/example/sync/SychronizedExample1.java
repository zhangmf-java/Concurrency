package com.imooc.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SychronizedExample1 {

    //修饰一个代码块
    public void test1(){
        synchronized (this){
            for (int i = 0;i < 10;i++){
                log.info("test1 - {}",i);
            }
        }
    }

    //修饰一个方法
    public synchronized void test2(){
        for (int i = 0;i < 10;i++){
            log.info("test2 - {}",i);
        }
    }

    public static void main(String[] args) {
        SychronizedExample1 example1 = new SychronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test1();
        });
        //使用线程池，调用一个方法后不等待该方法的执行结果，直接调用下一个方法
        executorService.execute(() -> {
            example1.test1();
        });
    }

}
