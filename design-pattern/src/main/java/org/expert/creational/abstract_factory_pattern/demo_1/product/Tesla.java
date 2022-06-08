package org.expert.creational.abstract_factory_pattern.demo_1.product;

/**
 * 角色:具体产品
 *
 * @author suzailong
 * @date 2022/6/8-2:26 下午
 */
public class Tesla extends AbstractCar {
    @Override
    public void drive() {
        System.out.println("Tesla models");
    }
}
