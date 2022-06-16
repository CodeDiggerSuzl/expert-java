package org.expert.structural.proxy_pattern.demo_1;

/**
 * @author suzailong
 * @date 2022/6/14-10:14 PM
 */
public class Client {
    public static void main(String[] args) {
        final BeerDrinkingProxy proxy = new BeerDrinkingProxy();
        proxy.drinkBeer(12);

        proxy.drinkBeer(19);
    }
}
