package com.liuwei.javaguide.basis;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wee
 * @Description:
 * @date 2020/6/3 10:50
 */
public class Test {


    public static void main(String[] args) throws ClassNotFoundException {
        List<Integer> value = Arrays.asList(1, 2, 3, 4);
//        Optional<Integer> max = value.stream().max(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
        Stream<Integer> integerStream = value.stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return 5 == integer;
            }
        });

        List<Integer> collect = integerStream.collect(Collectors.toList());
        collect.forEach(i -> System.out.println(i));
    }

}
