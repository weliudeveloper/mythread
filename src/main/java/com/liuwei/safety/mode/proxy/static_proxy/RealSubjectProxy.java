package com.liuwei.safety.mode.proxy.static_proxy;

/**
 * @author wee
 * @Description: 代理类 ---静态代理缺点：需要实现共同的接口
 * @date 2020/4/15 10:14
 */
public class RealSubjectProxy implements Subject {

    private RealSubject realSubject = null;

    @Override
    public Object request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        realSubject.request();//真正的请求
        return null;
    }

    public static void main(String[] args) {
        Subject proxy = new RealSubjectProxy();
        proxy.request();
    }
}
