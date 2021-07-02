package com.liuwei.javaguide.basis;

/**
 * @author wee
 */
public class MyStatic extends MyStaticFather {

    static int count = 1;

    public MyStatic() {
        System.out.println("我是构造方法" + count);
        count++;
    }

    {
        System.out.println("我是静态方法" + count);
    }

    static {
        System.out.println("我是静态代码块" + count);
    }


}
