package com.mmall.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.mmall.concurrency.annotations.ThreadNotSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@ThreadNotSafe
public class ImmutableExample1 {

    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
    }

    public static void main(String[] args) {
        //final修饰引用数据类型，引用不能再指向其他对象，但其值可以修改
        map.put(1, 3);
        log.info("{}", map.get(1));
    }

    private void test(final int a) {
//        a = 2;
    }
}
