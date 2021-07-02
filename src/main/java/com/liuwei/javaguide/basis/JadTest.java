package com.liuwei.javaguide.basis;

import java.text.Annotation;
import java.util.*;

/**
 * @author wee
 */
@SuppressWarnings({"ALL", "AlibabaClassMustHaveAuthor"})
public class JadTest {
    public static void main(String[] args) {
        List<Integer> num = new ArrayList<Integer>();
        num.add(1);
        num.add(2);
        num.add(3);
       /*int [] i = {1,2,3};
       Integer [] integers = new Integer[]{1,2,3};
        List<int[]> ints = Arrays.asList(i);
        List<Integer> integers1 = Arrays.asList(integers);
        System.out.println(ints.size());
        System.out.println(integers1.size());*/
       /* DummyEnum[] values = DummyEnum.values();
        EnumSet<DummyEnum> enumSet = EnumSet.of(DummyEnum.BLACK);
        for (DummyEnum element:
                enumSet) {
            System.out.println(element);
        }
        EnumMap enumMap = new EnumMap(DummyEnum.class);
        System.out.println(enumMap.isEmpty());*/
//       System.out.println(DummyEnum.BLACK.getName());
//        MyStatic myStatic = new MyStatic();
        /*try {
            Class<?> name = Class.forName("com.liuwei.javaguide.basis.JadTest");
            System.out.println(name);
        } catch (ClassNotFoundException e){

        }*/
       /* Class<JadTest> jadTestClass = JadTest.class;
        System.out.println(jadTestClass);*/
       /* Integer[] array = new Integer[]{3,4,2,5,1};
        System.out.println(min(Arrays.asList(array)));*/
        /*Iterator<Integer> iterator = num.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (2 == next){
                iterator.remove();
            }
        }*/
    }


    private static <T extends Number & Comparable<T>> T min(List<T> values) {
        if (values.isEmpty()) {
            return null;
        }
        T min = values.get(0);
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).compareTo(min) < 0) {
                min = values.get(i);
            }
        }

        return min;
    }
}
