package com.liuwei.javaguide.basis;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wee
 * @Description: 集合测试
 * @date 2020/4/12 16:25
 */
public class CollectionsTest {

    public static void main(String[] args) throws InterruptedException {
       /* Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        hashMap.put(null,1);
        hashMap.put(null,2);
        hashMap.put(1,5);
        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            println(next.getKey());
            println(next.getValue());
        }*/
//        println( sum(1));
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("D");
        list.add("C");
        list.add("B");

        list.sort(Comparator.comparing(String::hashCode));
        list.forEach(System.out::println);
    }

    public static void println(Object object) {
        System.out.println(object);
    }

    private static Integer sum(Integer value) {
        if (value == 5) {
            return 5;
        } else
            return value + (sum(value + 1));

    }
}
