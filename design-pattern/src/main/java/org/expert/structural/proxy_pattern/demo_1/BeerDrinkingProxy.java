package org.expert.structural.proxy_pattern.demo_1;

/**
 * 代理类: 强调的是对被代理对象的控制
 *
 * @author suzailong
 * @date 2022/6/14-10:08 PM
 */
public class BeerDrinkingProxy implements Drinkable {

    private final BeerDrinking beerDrinking;

    public BeerDrinkingProxy() {
        beerDrinking = new BeerDrinking();
    }

    @Override
    public void drinkBeer(int age) {
        final int auditAge = 18;
        // 虽然这个端代码可以不在代理类中调用
        // 但是因为我们编写代码的原则有：
        // 职责清晰：一个类只负责一件事；
        // 易于测试：一次只测一个功能。
        if (age > auditAge) {

            beerDrinking.drinkBeer(age);
        } else {
            System.out.println("too young to drink beer...");
        }
    }
}
