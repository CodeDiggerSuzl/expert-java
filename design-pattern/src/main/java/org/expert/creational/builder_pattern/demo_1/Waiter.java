package org.expert.creational.builder_pattern.demo_1;

/**
 * 角色: 指挥者
 *
 * @author suzailong
 * @date 2022/6/7-5:35 PM
 */
public class Waiter {
    private MealSetBuilder builder;

    public void setBuilder(MealSetBuilder builder) {
        this.builder = builder;
    }

    public MealSet prepareMeal() {
        builder.buildBottleSize("Large");
        builder.buildMainFood("Royal with Cheese");
        builder.buildDessert("Cup Cake");
        builder.buildDrink("Diet Coke");
        return builder.getMealSet();
    }

}
