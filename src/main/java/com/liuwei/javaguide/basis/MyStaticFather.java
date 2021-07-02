package com.liuwei.javaguide.basis;

/**
 * @author wee
 */
public class MyStaticFather {

    static int count = 1;

    public MyStaticFather() {
        System.out.println("我是父类构造方法" + count);
        count++;
    }

    {
        System.out.println("我是父类静态方法" + count);
    }

    static {
        System.out.println("我是父类静态代码块" + count);
    }


}
