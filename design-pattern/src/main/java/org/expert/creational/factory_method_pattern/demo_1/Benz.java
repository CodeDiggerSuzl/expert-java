package org.expert.creational.factory_method_pattern.demo_1;

/**
 * 角色：具体产品
 *
 * @author suzailong
 * @date 2022/6/7-3:04 PM
 */
public class Benz implements Vehicle {

    @Override
    public void price() {
        System.out.println("benz. price of $200,000");
    }
}
