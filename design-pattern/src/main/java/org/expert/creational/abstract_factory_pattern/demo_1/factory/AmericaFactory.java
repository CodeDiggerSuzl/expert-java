package org.expert.creational.abstract_factory_pattern.demo_1.factory;

import org.expert.creational.abstract_factory_pattern.demo_1.product.AbstractCar;
import org.expert.creational.abstract_factory_pattern.demo_1.product.AbstractPhone;
import org.expert.creational.abstract_factory_pattern.demo_1.product.IPhone;
import org.expert.creational.abstract_factory_pattern.demo_1.product.Tesla;

/**
 * @author suzailong
 * @date 2022/6/8-2:34 下午
 */
public class AmericaFactory extends AbstractFactory {

    @Override
    public AbstractCar createOneCar() {

        return new Tesla();
    }

    @Override
    public AbstractPhone createOnePhone() {
        return new IPhone();
    }
}
