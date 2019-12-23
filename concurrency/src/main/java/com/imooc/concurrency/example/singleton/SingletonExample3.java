package com.imooc.concurrency.example.singleton;

import com.imooc.concurrency.annotations.NotRecommend;
import com.imooc.concurrency.annotations.NotThreadSafe;
import com.imooc.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 * 只允许一个线程进入 带来不必要的性能消耗，不推荐
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    //构造方法私有化
    private SingletonExample3(){}

    //单例对象
    private static SingletonExample3 instance = null;

    //静态工厂方法
    public static synchronized SingletonExample3 getInstance(){
        if (instance == null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}
