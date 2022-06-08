package org.expert.creational.abstract_factory_pattern.demo_1.product;

/**
 * 角色: 抽象产品
 *
 * @author suzailong
 * @date 2022/6/8-11:38 上午
 */
public abstract class AbstractPhone {

    abstract void call();


    public void desc() {
        System.out.println("This is a phone");
        call();
    }
}
