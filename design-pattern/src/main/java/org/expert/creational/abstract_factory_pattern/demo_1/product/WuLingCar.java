package org.expert.creational.abstract_factory_pattern.demo_1.product;

/**
 * 角色:具体产品 2
 *
 * @author suzailong
 * @date 2022/6/8-2:36 下午
 */
public class WuLingCar extends AbstractCar {
    @Override
    public void drive() {
        System.out.println("this is a legendary car called the WuLing");
    }
}
