package com.liuwei.safety.mode.factory.impl;

import com.liuwei.safety.mode.factory.CatAbility;
import com.liuwei.safety.mode.factory.entity.CatEntity;

/**
 * @author wee
 * @Description:
 * @date 2020/4/14 10:30
 */
public class CatTom extends CatEntity {

    public CatTom() {
        super("Tom", "black");
    }

    @Override
    public void arrest() {
        System.out.println("Tom is arrest the mouse");
    }


}
