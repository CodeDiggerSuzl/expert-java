package org.expert.creational.simple_fatory_not_a_pattern.demo_1;

import org.expert.creational.simple_fatory_not_a_pattern.demo_1.product.Button;

/**
 * 角色: Client
 * <p>
 * 简单工厂模式( Simple Factory Pattern)
 * <p>
 * 简单来说: 多态和 if else 将不同的创建整合到一个"工厂🏭" 中
 * </p>
 * <a href="https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/simple_factory.html">related
 * link</a>
 *
 * @author suzailong
 * @date 2022/6/1-4:27 下午
 */
public class Client {
    public static void main(String[] args) {
        Button button = ButtonFactory.createFactory(1);

        String shape = button.generateShape();
        System.out.println(shape);
        button.onClick();
    }
}
