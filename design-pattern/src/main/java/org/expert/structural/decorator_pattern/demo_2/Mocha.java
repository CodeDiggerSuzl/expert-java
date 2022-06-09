package org.expert.structural.decorator_pattern.demo_2;

/**
 * 装饰者
 *
 * @author suzailong
 * @date 2022/6/8-11:47 下午
 */
public class Mocha extends CondimentDecorator {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
}
