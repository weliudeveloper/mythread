package com.liuwei.safety.mode.proxy.static_proxy;

/**
 * @author wee
 * @Description: 主题接口：定义代理类和真实主题的公共对外方法，也是代理类代理真实主题的方法
 * @date 2020/4/15 10:03
 */
public interface Subject {

    public Object request();

}
