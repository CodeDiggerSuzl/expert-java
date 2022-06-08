package org.expert.creational.factory_method_pattern.demo_2.factory;

import org.expert.creational.factory_method_pattern.demo_2.product.NewYorkCheesePizza;
import org.expert.creational.factory_method_pattern.demo_2.product.NewYorkMeatPizza;
import org.expert.creational.factory_method_pattern.demo_2.product.Pizza;

/**
 * @author suzailong
 * @date 2022/6/8-12:08 AM
 */
public class NewYorkAbstractPizzaStore extends AbstractPizzaStore {
    @Override
    Pizza createPizza(String type) {
        if ("cheese".equals(type)) {
            return new NewYorkCheesePizza("NY cheese pizza");
        }
        if ("meat".equals(type)) {
            return new NewYorkMeatPizza("NY meat pizza");
        }
        // return default pizza
        return new Pizza("default pizza");
    }
}
