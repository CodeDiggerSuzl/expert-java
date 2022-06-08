package org.expert.creational.factory_method_pattern.demo_2;

import org.expert.creational.factory_method_pattern.demo_2.factory.AbstractPizzaStore;
import org.expert.creational.factory_method_pattern.demo_2.factory.ChicagoAbstractPizzaStore;
import org.expert.creational.factory_method_pattern.demo_2.factory.NewYorkAbstractPizzaStore;
import org.expert.creational.factory_method_pattern.demo_2.product.Pizza;

/**
 * @author suzailong
 * @date 2022/6/8-12:20 AM
 */
public class Client {
    public static void main(String[] args) {
        // 声明具体的子工厂
        AbstractPizzaStore ps = new NewYorkAbstractPizzaStore();
        // 使用特定的子工厂创建对象
        Pizza pizza = ps.orderPizza("meat");
        System.out.println(pizza.getName());

        System.out.println("--".repeat(10));

        AbstractPizzaStore chicagoAbstractPizzaStore = new ChicagoAbstractPizzaStore();
        final Pizza pepper = chicagoAbstractPizzaStore.orderPizza("pepper");
        System.out.println(pepper.getName());
    }
}
