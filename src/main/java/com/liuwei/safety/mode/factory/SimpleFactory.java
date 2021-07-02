package com.liuwei.safety.mode.factory;

import com.liuwei.safety.mode.factory.entity.CatEntity;
import com.liuwei.safety.mode.factory.impl.CatJack;
import com.liuwei.safety.mode.factory.impl.CatTom;

/**
 * @author wee
 * @Description: 简单工厂父类--针对创建对象少---缺点：需要一个扩展类就必须创建一个扩展类，需要一个类型的实例就必须创建一个实例,并且判断中会无限增加
 * @date 2020/4/14 10:00
 */
public class SimpleFactory {

    public static CatEntity createCat(String name) {
        CatEntity catEntity;
        if (name.equals("TOM")) {
            catEntity = new CatTom();
        } else {
            catEntity = new CatJack("JACK", "blue");
        }

        return catEntity;
    }

    public static void main(String[] args) {
        CatEntity tom = SimpleFactory.createCat("TOM");
        tom.arrest();
    }
}
