package com.imooc.concurrency.example.concurrent;

import com.imooc.concurrency.annotations.ThreadSafe;
import com.imooc.concurrency.entity.User;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

@Slf4j
@ThreadSafe
public class RetainAllExample {
    /**
     * retainAll 求集合的交集
     *  使用 equals 方法 判断 集合中元素是否存在
     */

    public static void main(String[] args) throws InterruptedException {
//        List<String> list1 = new ArrayList<>();
//        list1.add("1");
//        list1.add("2");
//        list1.add("3");
//        List<String> list2 = new ArrayList<>();
//        list2.add("2");
//        list2.add("1");
//        list1.retainAll(list2);
//        for (String s : list1) {
//            System.out.println(s);
//        }

        List<User> list1 = new ArrayList<>();
        list1.add(new User("小明",14));
        list1.add(new User("小红",11));
        List<User> list2 = new ArrayList<>();
        list2.add(new User("小明",10));
        list1.retainAll(list2);
        for (User s : list1) {
            System.out.println(s);
        }
    }
}
