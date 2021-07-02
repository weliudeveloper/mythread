package com.liuwei.javaguide.basis;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wee
 * @Description:
 * @date 2020/4/12 17:23
 */
public class PersonComparable implements Comparable<PersonComparable> {

    private Integer age;

    private String name;

    public PersonComparable(String name, Integer age) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(PersonComparable o) {
        if (this.age > o.getAge()) {
            return 1;
        } else if (this.age < o.getAge()) {
            return -1;
        }
        return age;
    }

    public static void main(String[] args) {
        TreeMap<PersonComparable, String> pdata = new TreeMap<PersonComparable, String>();
        pdata.put(new PersonComparable("张三", 30), "zhangsan");
        pdata.put(new PersonComparable("李四", 20), "lisi");
        pdata.put(new PersonComparable("王五", 10), "wangwu");
        pdata.put(new PersonComparable("小红", 5), "xiaohong");
        // 得到key的值的同时得到key所对应的值
        Set<PersonComparable> keys = pdata.keySet();
        for (PersonComparable key : keys) {
            System.out.println(key.getAge() + "-" + key.getName());

        }

    }

}
