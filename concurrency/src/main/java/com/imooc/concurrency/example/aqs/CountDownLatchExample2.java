package com.imooc.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.sql.Time;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CountDownLatchExample2 {

    private static int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService exec = Executors.newCachedThreadPool();

        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0;i < threadCount;i++){
            final int threadNum = i;

            exec.execute(() -> {
                try {
                    Thread.sleep(100);
                    test(threadNum);
                }catch (Exception e){
                    log.error("exception",e);
                }finally {
                    countDownLatch.countDown();
                }
            });
        }

        //1.await。计数器为0时，则执行await方法后面的逻辑，可以指定等待时间，比如十秒，如果超过十秒，不管countDown计数器是否为0，都会执行await后面的逻辑
        //注意：await这里的等待时间，表示的是逻辑执行时间，所以，不能把sleep放在for循环之内
        //注意：exec.shutdown()之后，线程并不会立马关闭，而是会等待当前任务执行完毕
        //2.countdown(),计数器减一
        countDownLatch.await(10, TimeUnit.MILLISECONDS);
        log.info("finish");
        exec.shutdown();
    }

    private static void test(int threadCount) throws InterruptedException {
        log.info("{}",threadCount);
    }
}
