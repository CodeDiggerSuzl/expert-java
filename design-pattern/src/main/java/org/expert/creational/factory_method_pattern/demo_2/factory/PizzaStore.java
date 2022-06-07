package org.expert.creational.factory_method_pattern.demo_2.factory;

import org.expert.creational.factory_method_pattern.demo_2.product.Pizza;

/**
 * @author suzailong
 * @date 2022/6/8-12:02 AM
 */
public abstract class PizzaStore {
    /**
     * 子类对订单的处理保持一致
     */
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.slice();
        pizza.box();
        return pizza;
    }

    /**
     * 不同的子类对 pizza 的制作进行定制化
     */
    abstract Pizza createPizza(String type);
}
