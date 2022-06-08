package org.expert.creational.abstract_factory_pattern.demo_1.factory;

import org.expert.creational.abstract_factory_pattern.demo_1.product.AbstractCar;
import org.expert.creational.abstract_factory_pattern.demo_1.product.AbstractPhone;

/**
 * 抽象工厂
 *
 * @author suzailong
 * @date 2022/6/8-11:36 上午
 */
public abstract class AbstractFactory {
    
    public abstract AbstractCar createOneCar();

    public abstract AbstractPhone createOnePhone();
}
