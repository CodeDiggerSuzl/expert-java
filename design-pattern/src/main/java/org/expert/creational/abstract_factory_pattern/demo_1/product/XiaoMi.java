package org.expert.creational.abstract_factory_pattern.demo_1.product;

/**
 * 角色:抽象产品
 *
 * @author suzailong
 * @date 2022/6/8-2:24 下午
 */
public class XiaoMi extends AbstractPhone {

    @Override
    void call() {
        System.out.println("this is a xiaomi phone");
    }
}
