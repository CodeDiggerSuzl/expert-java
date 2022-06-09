package org.expert.structural.decorator_pattern.demo_2;

import org.expert.structural.decorator_pattern.demo_2.ingredients.Espresso;
import org.expert.structural.decorator_pattern.demo_2.ingredients.HouseBlend;

/**
 * @author suzailong
 * @date 2022/6/8-11:50 下午
 */
public class Client {
    public static void main(String[] args) {
        // 摩卡装饰 house blend
        Drinkable houseBlend = new HouseBlend();
        Drinkable mocha = new Mocha(houseBlend);
        System.out.println("mocha.getDescription() = " + mocha.getDescription());
        System.out.println("mocha.cost() = " + mocha.cost());
        System.out.println("**".repeat(10));

        // 摩卡装饰 espresso
        Drinkable espresso = new Espresso();
        Drinkable mochaWithEspresso = new Mocha(espresso);
        System.out.println("mochaWithEspresso.getDescription() = " + mochaWithEspresso.getDescription());
        System.out.println("mocha.cost() = " + mochaWithEspresso.cost());


        System.out.println("**".repeat(10));
        Drinkable mochaWithEspressoWithSoyMilk = new SoyMilk(mochaWithEspresso);
        System.out.println("mochaWithEspressoWithSoyMilk.getDescription() = " + mochaWithEspressoWithSoyMilk.getDescription());
        System.out.println("mochaWithEspressoWithSoyMilk.cost() = " + mochaWithEspressoWithSoyMilk.cost());
    }
}
