package org.expert.creational.simple_fatory_not_a_pattern.demo_1;

import org.expert.creational.simple_fatory_not_a_pattern.demo_1.product.AbstractButton;
import org.expert.creational.simple_fatory_not_a_pattern.demo_1.product.RoundAbstractButton;
import org.expert.creational.simple_fatory_not_a_pattern.demo_1.product.SquareAbstractButton;

/**
 * 简单工厂模式( Simple Factory Pattern)
 *
 * <p>
 * 简单来说: 多态和 if else 将不同的创建整合到一个"工厂🏭" 中
 * </p>
 *
 * <a href="https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/simple_factory.html">related link</a>
 * <p></p>
 * <b>角色: 工厂</b>
 *
 * @author suzailong
 * @date 2022/6/1-4:23 下午
 */
public class ButtonFactory {
    /**
     * 根据需求不同来创建不同的 Button 子类
     */
    static AbstractButton createFactory(int type) {
        if (type == 1) {
            return new RoundAbstractButton();
        } else {
            return new SquareAbstractButton();
        }
    }
}
