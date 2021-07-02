package com.liuwei.safety.mode.factory;

import com.liuwei.safety.mode.factory.entity.CatEntity;
import com.liuwei.safety.mode.factory.impl.CatTom;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.MapFactoryBean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wee
 * @Description: 体工厂(Concrete Factory)角色 ：这是实现抽象工厂接口的具体工厂类，包含与应用程序密切相关的逻辑，并且受到应用程序调用以创建某一种产品对象。
 * @date 2020/4/14 10:58
 */
public class MethodFactoryCon implements MethodFactoryAbs {

    @Override
    public CatEntity getCat() {
        return new CatTom();
    }

    public static void main(String[] args) {
        MethodFactoryCon con = new MethodFactoryCon();
        CatTom cat = (CatTom) con.getCat();
        cat.arrest();

    }
}
