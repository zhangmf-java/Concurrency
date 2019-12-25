package com.imooc.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.imooc.concurrency.annotations.NotThreadSafe;
import com.imooc.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

@Slf4j
@ThreadSafe
public class ImmutableExample2 {

    private static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
        // 被unmodifiableMap（）
        // 方法修改之后的map 不能被重新赋值 且 map内的值不能被修改
        // 原理 new 一个 UnmodifiableMap 并把原来map中的值copy进去，
        // 修改一切修改map值的方法为抛出异常

        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {

        map.put(1,3);
        log.info("{}",map.get(1));

    }
}
