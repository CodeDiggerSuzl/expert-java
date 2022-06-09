package org.expert.structural.decorator_pattern.demo_2;

/**
 * @author suzailong
 * @date 2022/6/8-11:50 下午
 */
public class Client {
    public static void main(String[] args) {
        Beverage espresso = new Expresso();

        Beverage houseBlend = new HouseBlend();
        Beverage mocha = new Mocha(houseBlend);
        System.out.println("mocha.getDescription() = " + mocha.getDescription());
        System.out.println("mocha.cost() = " + mocha.cost());

        System.out.println("**".repeat(10));

        // 摩卡装饰 espresso
        Beverage mochaWithEspresso = new Mocha(espresso);
        System.out.println("mochaWithEspresso.getDescription() = " + mochaWithEspresso.getDescription());
        System.out.println("mocha.cost() = " + mocha.cost());
    }
}
