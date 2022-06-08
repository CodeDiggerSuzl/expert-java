package org.expert.creational.abstract_factory_pattern.demo_1.factory;

import org.expert.creational.abstract_factory_pattern.demo_1.product.AbstractCar;
import org.expert.creational.abstract_factory_pattern.demo_1.product.AbstractPhone;
import org.expert.creational.abstract_factory_pattern.demo_1.product.WuLingCar;
import org.expert.creational.abstract_factory_pattern.demo_1.product.XiaoMi;

/**
 * 角色:具体工厂
 *
 * @author suzailong
 * @date 2022/6/8-2:32 下午
 */
public class ShanghaiFactory extends AbstractFactory {
    @Override
    public AbstractCar createOneCar() {
        return new WuLingCar();
    }

    @Override
    public AbstractPhone createOnePhone() {
        return new XiaoMi();
    }
}
