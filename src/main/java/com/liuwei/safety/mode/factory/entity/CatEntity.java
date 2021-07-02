package com.liuwei.safety.mode.factory.entity;

import com.liuwei.safety.mode.factory.CatAbility;

/**
 * @author wee
 * @Description:
 * @date 2020/4/14 10:31
 */
public class CatEntity implements CatAbility {
    protected String name;
    protected String color;

    public CatEntity(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void arrest() {

    }
}
