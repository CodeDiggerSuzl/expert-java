package org.expert.structural.decorator_pattern.demo_2;

/**
 * 角色: 具体组件
 *
 * @author suzailong
 * @date 2022/6/8-11:40 下午
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "HouseBlend";
    }

    @Override
    public double cost() {
        return .89;
    }
}
