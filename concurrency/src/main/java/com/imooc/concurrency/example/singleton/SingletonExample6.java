package com.imooc.concurrency.example.singleton;

import com.imooc.concurrency.annotations.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类装载时进行创建
 * 缺点：如果只加载没调用，会有资源浪费
 */
@ThreadSafe
public class SingletonExample6 {

    //构造方法私有化
    private SingletonExample6(){

    }

    /**
     * 一定要注意静态方法与静态域的执行顺序
     */

    //单例对象
    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }


    //静态工厂方法
    public static SingletonExample6 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
