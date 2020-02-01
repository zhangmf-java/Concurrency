package com.imooc.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class FutureExample1 {

    //要实现Callable接口 泛型为返回值类型
    static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            log.info("do something in callable");
            Thread.sleep(5000);
            return "Done";
        }
    }

    /**
     * 1.首先输出 "do something in callable"
     * 2.再输出 "do something in main"
     * 3.main 方法睡眠 1s
     * 4.future.get（） 将会睡眠当前线程（main）以等待Callable 线程返回结果
     * 5.Callable线程执行完成 future.get()获得执行结果 输出 "result:Done"
     * @param args
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());
        log.info("do something in main");
        Thread.sleep(1000);
        String s = future.get();
        log.info("result:{}",s);

    }

}
