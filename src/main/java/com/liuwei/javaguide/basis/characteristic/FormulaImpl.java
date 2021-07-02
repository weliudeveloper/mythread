package com.liuwei.javaguide.basis.characteristic;

import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

import java.nio.Buffer;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author wee
 * @Description:
 * @date 2020/4/15 14:21
 */
public class FormulaImpl implements Formula {
    @Override
    public String getString() {
        return "hello";
    }

    public static void main(String[] args) {
        //Formula formula = new FormulaImpl();
        //System.out.println(formula.getString());

       /* List<Integer> lambada = new ArrayList<>(Arrays.asList(3,2,4,5,1,6));
        lambada.sort((a, b) -> a.compareTo(b));
        lambada.forEach(i -> System.out.println(i));*/
       /* Converter<String, Integer> converter = Integer::valueOf;
        Integer convert = converter.convert("123");
        */
        /*final int num = 1;
        Converter<String, Integer> converter = (value) -> Integer.valueOf(value) + num;
        Integer convert = converter.convert("2");
        System.out.println(convert);*/
       /* List<Integer> lambada = new ArrayList<>(Arrays.asList(3,2,4,5,1,6,1,1));
        long count = lambada.stream().filter(i -> i == 1).count();*/
//        System.out.println(count);
//        lambada.stream().sorted().forEach(System.out::println);
       /* Stream<Integer> distinct = lambada.stream().distinct();
        distinct.forEach(System.out::println);*/
/*
        long start = System.currentTimeMillis();
        Clock clock = Clock.systemDefaultZone();
        long end = clock.millis();
        System.out.println(end - start);
        Instant instant = clock.instant();
        Date date = Date.from(instant);
        System.out.println(date);*/
        /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        println(localDate.format(formatter));*/
        String[] array = {"flower", "flow", "flight"};
        int mark = 0;
        int size = 0;
        for (int i = 0; i < array.length; i++) {
            int elementSize = array[i].length();
            if (i == 0) {
                size = elementSize;
            } else {
                if (size > elementSize) {
                    size = elementSize;
                    mark = i;
                }
            }
        }
        String minValue = array[mark];
        char[] chars = minValue.toCharArray();
        List<String> val = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            val.add(array[i]);
        }
        StringBuffer buffer = new StringBuffer();
        int valSize = val.size();
        int count = 0;
        for (char element : chars) {
            for (int i = 0; i < val.size(); i++) {
                if (val.get(i).contains(String.valueOf(element))) {
                    count++;
                }
            }
            if (count == valSize) {
                buffer.append(element);
            }
            count = 0;
        }
        System.out.println(buffer);
    }

    private static void println(Object object) {
        System.out.println(object);
    }
}
