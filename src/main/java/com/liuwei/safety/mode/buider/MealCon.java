package com.liuwei.safety.mode.buider;

/**
 * @author wee
 * @Description: 具体建造者
 * @date 2020/4/14 14:14
 */
public class MealCon extends MealBuilder {


    @Override
    public void buildFood() {
        meal.setFood("汉堡");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("可乐");
    }

    @Override
    public Meal getMeal() {
        return super.getMeal();
    }
}
