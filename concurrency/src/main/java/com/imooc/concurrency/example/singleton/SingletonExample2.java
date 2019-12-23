package com.imooc.concurrency.example.singleton;

import com.imooc.concurrency.annotations.NotThreadSafe;
import com.imooc.concurrency.annotations.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类装载时进行创建
 * 缺点：如果只加载没调用，会有资源浪费
 */
@ThreadSafe
public class SingletonExample2 {

    //构造方法私有化
    private SingletonExample2(){}

    //单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    //静态工厂方法
    public static SingletonExample2 getInstance(){
        return instance;
    }
}
