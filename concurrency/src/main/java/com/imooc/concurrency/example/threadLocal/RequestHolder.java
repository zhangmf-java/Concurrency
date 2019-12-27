package com.imooc.concurrency.example.threadLocal;

public class RequestHolder {

    /**
     * threadLocal是map结构   key为当前线程的id    value 为 set方法的变量
     */
    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id){
        requestHolder.set(id);
    }

    public static Long getId(){
        return requestHolder.get();
    }

    /**
     * 移除当前变量信息
     * 不移除将发生内存泄漏，直到项目关闭，存储的值才能释放
     */
    public static void remove(){
        requestHolder.remove();
    }

}
