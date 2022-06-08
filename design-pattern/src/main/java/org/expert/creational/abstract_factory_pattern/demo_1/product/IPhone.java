package org.expert.creational.abstract_factory_pattern.demo_1.product;

/**
 * 角色: 具体产品
 *
 * @author suzailong
 * @date 2022/6/8-11:42 上午
 */
public class IPhone extends AbstractPhone {

    @Override
    void call() {
        System.out.println("Calling by IPhone");
    }
}
