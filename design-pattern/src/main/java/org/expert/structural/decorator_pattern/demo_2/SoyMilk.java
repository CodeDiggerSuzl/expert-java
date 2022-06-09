package org.expert.structural.decorator_pattern.demo_2;

/**
 * 装饰类
 *
 * @author suzailong
 * @date 2022/6/9-1:24 下午
 */
public class SoyMilk extends CondimentDecorator {

    private final Drinkable drinkable;

    public SoyMilk(Drinkable drinkable) {
        this.drinkable = drinkable;
    }

    @Override
    public double cost() {

        System.out.println("[decorator] Soy milk cost .80");
        return 0.80D + drinkable.cost();
    }

    @Override
    public String getDescription() {
        return drinkable.getDescription() + ", Soy milk";
    }
}
