package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.NotRecommend;
import com.mmall.concurrency.annotations.ThreadNotSafe;
import com.mmall.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式 -》 双重同步锁单例模式
 * 单例实例在第一次使用时进行创建
 */
@ThreadNotSafe
public class SingletonExample4 {

    //私有构造函数
    private SingletonExample4() {}

    //单例对象
    private static SingletonExample4 instance = null;

    //静态的工厂方法
    public static synchronized SingletonExample4 getInstance() {
        if (instance == null) { //双重检测机制
            synchronized (SingletonExample4.class) { //同步锁
                if (instance == null) {
                    instance = new SingletonExample4();
                    //new行为
                    //1、memory = allocate() 分配内存
                    //2、ctoInstance() 初始化对象
                    //3、instance = memory 设置instance指向刚分配的内存

                    //JVM和cpu优化，发生了指令重排，132
                }
            }
        }
        return instance;
    }
}
