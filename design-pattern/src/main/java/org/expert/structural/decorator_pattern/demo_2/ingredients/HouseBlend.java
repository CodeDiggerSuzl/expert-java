package org.expert.structural.decorator_pattern.demo_2.ingredients;

import org.expert.structural.decorator_pattern.demo_2.Drinkable;

/**
 * 角色: 具体组件
 *
 * <p>黑咖啡,不能装饰别人,基础咖啡</p>
 *
 * @author suzailong
 * @date 2022/6/8-11:40 下午
 */
public class HouseBlend extends Drinkable {

    public HouseBlend() {
        this.description = "HouseBlend";
    }

    @Override
    public double cost() {
        System.out.println("[basic ingredient] house blend cost 0.89");
        return .89;
    }
}
