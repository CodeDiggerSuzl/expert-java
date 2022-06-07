package org.expert.creational.factory_method_pattern.demo_2;

import org.expert.creational.factory_method_pattern.demo_2.factory.ChicagoPizzaStore;
import org.expert.creational.factory_method_pattern.demo_2.factory.NewYorkPizzaStore;
import org.expert.creational.factory_method_pattern.demo_2.factory.PizzaStore;
import org.expert.creational.factory_method_pattern.demo_2.product.Pizza;

/**
 * @author suzailong
 * @date 2022/6/8-12:20 AM
 */
public class Client {
    public static void main(String[] args) {
        // 声明具体的子工厂
        PizzaStore ps = new NewYorkPizzaStore();
        // 使用特定的子工厂创建对象
        Pizza pizza = ps.orderPizza("meat");
        System.out.println(pizza.getName());

        System.out.println("--".repeat(10));

        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        final Pizza pepper = chicagoPizzaStore.orderPizza("pepper");
        System.out.println(pepper.getName());
    }
}
