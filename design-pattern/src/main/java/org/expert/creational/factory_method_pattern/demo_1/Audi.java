package org.expert.creational.factory_method_pattern.demo_1;

/**
 * 角色：具体产品
 *
 * @author suzailong
 * @date 2022/6/7-3:06 PM
 */
public class Audi implements Vehicle {
    @Override
    public void price() {
        System.out.println("audi, price with $300,000");
    }
}
