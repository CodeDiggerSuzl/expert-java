package org.expert.creational.builder_pattern.demo_1

/**
 *
 * @author suzailong* @date 2022/6/7-6:17 PM
 */
class GroovyClient {
    static void main(String[] args) {
        def waiter = new Waiter()
        waiter.setBuilder(new KfcBuilderAbstract())

        def meal = waiter.prepareMeal()
        println(meal)
    }

}
