package org.expert.creational.factory_method_pattern.demo_2.factory;

import org.expert.creational.factory_method_pattern.demo_2.product.ChicagoPepperPizza;
import org.expert.creational.factory_method_pattern.demo_2.product.Pizza;

/**
 * 角色:具体工厂
 *
 * @author suzailong
 * @date 2022/6/8-12:08 AM
 */
public class ChicagoAbstractPizzaStore extends AbstractPizzaStore {
    @Override
    Pizza createPizza(String type) {
        if ("pepper".equals(type)) {
            return new ChicagoPepperPizza("Chicago pepper pizza");
        }
        // return default pizza
        return new Pizza("default pizza");
    }
}
