package com.imooc.concurrency.example.concurrent;

import com.imooc.concurrency.annotations.NotThreadSafe;
import com.imooc.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

@Slf4j
@ThreadSafe
public class CopyOnWriteSetExample {

    /**
     * add  remove ... 线程安全
     * containsAll addAll removeAll ... 线程不安全
     */

    //请求总数
    public static int clientTotal = 5000;

    //允许并发执行的线程数
    private static int threadTotal = 200;

    private static Set<Integer> set = new CopyOnWriteArraySet<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update(count);
                    semaphore.release();
                } catch (Exception e) {
                    log.error("Exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("size:{}",set.size());
    }
    private static void update(int i){
        set.add(i);
    }
}
