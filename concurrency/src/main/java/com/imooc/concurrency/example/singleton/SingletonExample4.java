package com.imooc.concurrency.example.singleton;

import com.imooc.concurrency.annotations.NotRecommend;
import com.imooc.concurrency.annotations.NotThreadSafe;
import com.imooc.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式 -》双重同步锁单例模式
 * 单例实例在第一次使用时进行创建
 */
@NotThreadSafe
public class SingletonExample4 {

    //构造方法私有化
    private SingletonExample4(){}

    //单例对象
    private static SingletonExample4 instance = null;

    /**
     * new SingletonExample4()
     * 1、 memory = allocate() 分配对象内存空间
     * 2、ctorInstance() 初始化对象
     * 3、instance = memory 设置 instance指向刚分配的内存
     */

    //JVM和CPU优化  发生了指令重排

    /**
     * 1、 memory = allocate() 分配对象内存空间
     * 3、instance = memory 设置 instance指向刚分配的内存
     * 2、ctorInstance() 初始化对象
     */

    //静态工厂方法
    public static SingletonExample4 getInstance(){
        if (instance == null){//双重检测机制
            synchronized (SingletonExample4.class){//同步锁
                if (instance == null){
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
