package com.liuwei.safety.mode.factory;

import com.liuwei.safety.mode.factory.entity.CatEntity;

/**
 * @author wee
 * @Description: 抽象工厂(Abstract Factory)角色：是工厂方法模式的核心，与应用程序无关。任何在模式中创建的对象的工厂类必须实现这个接口。
 * @date 2020/4/14 10:58
 */
public interface MethodFactoryAbs {

    public CatEntity getCat();
}
