package com.liuwei.safety.mode.factory;

import com.liuwei.safety.mode.factory.entity.CatEntity;
import com.liuwei.safety.mode.factory.impl.CatTom;

/**
 * @author wee
 * @Description: 利用反射解决简单工厂每次增加新了产品类都要修改产品工厂的弊端, 缺点：需要一个扩展类就必须创建一个扩展类
 * @date 2020/4/14 10:44
 */
public class SimpleFactoryRel {

    public static Object createCat(String name, Class<? extends CatEntity> className) {
        Object object = null;
        try {
            object = Class.forName(className.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return object;
    }

    public static void main(String[] args) {
        CatTom tom = (CatTom) SimpleFactoryRel.createCat("Tom", CatTom.class);
        tom.arrest();
    }
}
