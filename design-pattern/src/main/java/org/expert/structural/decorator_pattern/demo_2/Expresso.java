package org.expert.structural.decorator_pattern.demo_2;

/**
 * 浓缩咖啡
 *
 * @author suzailong
 * @date 2022/6/8-11:40 下午
 */
public class Expresso extends Beverage {

    public Expresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
