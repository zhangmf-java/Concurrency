package com.imooc.concurrency.example.singleton;

import com.imooc.concurrency.annotations.NotThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 * 如果构造方法比较复杂，会影响性能
 */
@NotThreadSafe
public class SingletonExample1 {

    //构造方法私有化
    private SingletonExample1(){}

    //单例对象
    private static SingletonExample1 instance = null;

    //静态工厂方法
    public static SingletonExample1 getInstance(){
        if (instance == null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}
