package com.liuwei.safety.mode.proxy.cglib_dynamic_proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author wee
 * @Description: CGLIB代理类 -- CGLIB好处：并不需要实现接口
 * @date 2020/4/15 11:07
 */
public class BookProxyLib implements MethodInterceptor {

    private Object target;

    /**
     * 创建代理对象
     *
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("事物开始");
        proxy.invokeSuper(obj, args);
        System.out.println("事物结束");
        return null;
    }

    public static void main(String[] args) {
        BookProxyLib cglib = new BookProxyLib();
        BookSubject bookCglib = (BookSubject) cglib.getInstance(new BookSubject());
        bookCglib.addBook();
    }
}
