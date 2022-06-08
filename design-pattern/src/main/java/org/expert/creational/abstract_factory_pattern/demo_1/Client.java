package org.expert.creational.abstract_factory_pattern.demo_1;

import org.expert.creational.abstract_factory_pattern.demo_1.factory.AbstractFactory;
import org.expert.creational.abstract_factory_pattern.demo_1.factory.AmericaFactory;
import org.expert.creational.abstract_factory_pattern.demo_1.factory.ShanghaiFactory;
import org.expert.creational.abstract_factory_pattern.demo_1.product.AbstractCar;
import org.expert.creational.abstract_factory_pattern.demo_1.product.AbstractPhone;

/**
 * @author suzailong
 * @date 2022/6/8-2:38 下午
 */
public class Client {
    public static void main(String[] args) {
        AbstractFactory factory = new ShanghaiFactory();
        AbstractPhone onePhone = factory.createOnePhone();
        onePhone.desc();
        AbstractCar oneCar = factory.createOneCar();
        oneCar.drive();

        System.out.println("---".repeat(10));

        AbstractFactory factory1 = new AmericaFactory();
        AbstractPhone phone = factory1.createOnePhone();
        phone.desc();
        AbstractCar car = factory1.createOneCar();
        car.drive();

    }
}
