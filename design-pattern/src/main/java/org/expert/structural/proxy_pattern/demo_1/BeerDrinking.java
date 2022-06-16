package org.expert.structural.proxy_pattern.demo_1;

/**
 * @author suzailong
 * @date 2022/6/14-10:08 PM
 */
public class BeerDrinking implements Drinkable {
    @Override
    public void drinkBeer(int age) {
        System.out.println("drink beer... at age: " + age);
    }
}
