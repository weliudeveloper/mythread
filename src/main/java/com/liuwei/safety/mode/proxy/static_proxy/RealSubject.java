package com.liuwei.safety.mode.proxy.static_proxy;

/**
 * @author wee
 * @Description: 真实主题，负责实际的业务操作
 * @date 2020/4/15 10:14
 */
public class RealSubject implements Subject {

    @Override
    public Object request() {
        System.out.println("我正在进行数据库查询");
        return null;
    }
}
