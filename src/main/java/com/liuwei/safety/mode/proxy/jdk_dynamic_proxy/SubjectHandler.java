package com.liuwei.safety.mode.proxy.jdk_dynamic_proxy;

import com.liuwei.safety.mode.proxy.static_proxy.RealSubject;
import com.liuwei.safety.mode.proxy.static_proxy.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wee
 * @Description: JDK 的动态代理需要实现一个处理方法调用的 Handler，用于实现代理方法的内部逻辑。
 * @date 2020/4/15 10:29
 */
public class SubjectHandler implements InvocationHandler {

    Subject subject = null;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (subject == null) {
            subject = new RealSubject();
        }

        return subject.request();
    }

    public static Subject createProxy() {
        Subject proxy = (Subject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Subject.class}, new SubjectHandler());
        return proxy;
    }

    public static void main(String[] args) throws Throwable {
        Subject proxy = SubjectHandler.createProxy();
        proxy.request();
    }
}
