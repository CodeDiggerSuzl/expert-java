package org.expert.creational.builder_pattern.demo_1;

/**
 * @author suzailong
 * @date 2022/6/7-5:24 PM
 */
public class KfcBuilder extends MealSetBuilder {

    private final MealSet ms = new MealSet();

    @Override
    void buildDrink(String drink) {
        ms.setDrink(drink);
    }

    @Override
    void buildDessert(String dessert) {
        ms.setDessert(dessert);
    }

    @Override
    void buildMainFood(String mainFood) {
        ms.setMainFood(mainFood);
    }

    @Override
    void buildBottleSize(String bottleSize) {
        ms.setBottleSize(bottleSize);
    }

    @Override
    MealSet getMealSet() {
        return ms;
    }
}
