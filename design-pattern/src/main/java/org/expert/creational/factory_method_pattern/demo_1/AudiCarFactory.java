package org.expert.creational.factory_method_pattern.demo_1;

/**
 * 角色：具体的工厂
 *
 * @author suzailong
 * @date 2022/6/7-3:08 PM
 */
public class AudiCarFactory implements CarFactory {

    @Override
    public Vehicle createVehicle() {
        return new Audi();
    }
}
