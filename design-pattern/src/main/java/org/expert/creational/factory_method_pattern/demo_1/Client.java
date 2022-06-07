package org.expert.creational.factory_method_pattern.demo_1;


/**
 * 角色：调用者
 *
 * @author suzailong
 * @date 2022/6/7-2:44 PM
 */
public class Client {
    public static void main(String[] args) {
        // 调用特定的工厂
        final Vehicle vehicle = new AudiCarFactory().createVehicle();
        vehicle.price();

        // 工厂多态，产品多态
        final CarFactory benzFactory = new BenzCarFactory();
        final Vehicle benz = benzFactory.createVehicle();
        benz.price();


    }
}
