package com.imooc.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class SemaphoreExample1 {

    /**
     * semaphore(信号量):规定同一时间可访问的线程数量
     * 1.acquire：获取许可。 semaphore.acquire(n)一次可以获得多个许可
     * 2.release：释放许可。 semaphore.release(n) 一次可以释放多个许可
     * 3.tryAcquire:尝试获取许可  可以设置时间与给定个数
     */


    private static int threadCount = 20;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0;i < threadCount;i++){
            final int threadNum = i;

            exec.execute(() -> {
                try {
                    semaphore.acquire();//获取一个许可
                    test(threadNum);
                    semaphore.release();//释放一个许可
                }catch (Exception e){
                    log.error("exception",e);
                }
            });
        }
        exec.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        log.info("{}",threadNum);
        Thread.sleep(1000);
    }
}
