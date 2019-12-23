package com.imooc.concurrency.example.singleton;

import com.imooc.concurrency.annotations.Recommod;
import com.imooc.concurrency.annotations.ThreadSafe;

/**
 * 枚举模式：最安全
 */
@ThreadSafe
@Recommod
public class SingletonExample7 {

    //构造方法私有化
    private SingletonExample7(){

    }

    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private SingletonExample7 singleton;

        //JVM保证这个方法只调用一次
        //在类初始化完成之后
        Singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance(){
            return singleton;
        }
    }
}
