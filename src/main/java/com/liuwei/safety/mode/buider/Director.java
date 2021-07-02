package com.liuwei.safety.mode.buider;

import com.sun.xml.internal.ws.api.server.Adapter;

/**
 * @author wee
 * @Description: 指挥者
 * @date 2020/4/14 14:18
 */
public class Director {

    private MealBuilder mealBuilder;

    public Director(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    public Meal construct() {
        mealBuilder.buildFood();
        mealBuilder.buildDrink();
        return mealBuilder.getMeal();
    }

    public static void main(String[] args) {
        MealCon colo = new MealCon();
        Director director = new Director(colo);
        Meal construct = director.construct();
        construct.getDrink();
        System.out.println(construct.getFood());
    }
}
