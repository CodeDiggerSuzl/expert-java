package org.expert.creational.builder_pattern.demo_1;

/**
 * 角色: 套餐构建者
 *
 * @author suzailong
 * @date 2022/6/7-5:18 PM
 */
public abstract class AbstractMealSetBuilder {

    abstract void buildDrink(String drink);

    abstract void buildDessert(String dessert);

    abstract void buildMainFood(String mainFood);

    abstract void buildBottleSize(String bottleSize);

    abstract MealSet getMealSet();
}
