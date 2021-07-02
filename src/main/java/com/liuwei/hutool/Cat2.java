package com.liuwei.hutool;

import cn.hutool.core.clone.CloneSupport;
import cn.hutool.core.clone.Cloneable;

/**
 * @author wee
 * @Description:
 * @date 2020/12/18 14:48
 */
public class Cat2 extends CloneSupport<Cat2> {

    private String name = "maomao2";
    private int age = 2;

   /* @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }*/
}
