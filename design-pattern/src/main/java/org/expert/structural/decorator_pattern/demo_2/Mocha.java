package org.expert.structural.decorator_pattern.demo_2;

/**
 * 装饰者
 *
 * @author suzailong
 * @date 2022/6/8-11:47 下午
 */
public class Mocha extends CondimentDecorator {

    Drinkable drinkable;

    public Mocha(Drinkable drinkable) {
        this.drinkable = drinkable;
    }

    @Override
    public double cost() {
        double cost = drinkable.cost();
        System.out.println("[decorator] mocha cost 0.20");
        return .20 + cost;
    }

    @Override
    public String getDescription() {
        return drinkable.getDescription() + ", Mocha";
    }
}
