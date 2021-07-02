package com.liuwei.safety.mode.factory.impl;

import com.liuwei.safety.mode.factory.CatAbility;
import com.liuwei.safety.mode.factory.entity.CatEntity;

/**
 * @author wee
 * @Description:
 * @date 2020/4/14 10:32
 */
public class CatJack extends CatEntity {

    public CatJack(String name, String color) {
        super(name, color);
    }

    @Override
    public void arrest() {
        System.out.println("Jack is arrest the mouse");
    }
}
