package com.liuwei.safety.mode.buider;

/**
 * @author wee
 * @Description: 抽象建造者
 * @date 2020/4/14 14:11
 */
public abstract class MealBuilder {
    Meal meal = new Meal();

    public abstract void buildFood();

    public abstract void buildDrink();

    public Meal getMeal() {
        return meal;
    }
}
