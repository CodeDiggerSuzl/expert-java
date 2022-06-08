package org.expert.creational.builder_pattern.demo_1;

/**
 * Client
 *
 * @author suzailong
 * @date 2022/6/7-6:01 PM
 */
public class Client {
    public static void main(String[] args) {
        final Waiter waiter = new Waiter();
        waiter.setBuilder(new KfcBuilderAbstract());

        final MealSet mealSet = waiter.prepareMeal();
        System.out.println(mealSet.toString());
    }
}
