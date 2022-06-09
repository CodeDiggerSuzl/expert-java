package org.expert.structural.decorator_pattern.demo_2.ingredients;

import org.expert.structural.decorator_pattern.demo_2.Drinkable;

/**
 * 浓缩咖啡
 * <p>只能被装饰,不能装饰别人,基础咖啡</p>
 *
 * @author suzailong
 * @date 2022/6/8-11:40 下午
 */
public class Espresso extends Drinkable {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        System.out.println("[basic ingredient] espresso cost 1.99");
        return 1.99;
    }
}
