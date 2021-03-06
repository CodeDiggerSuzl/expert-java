package org.expert.creational.simple_fatory_not_a_pattern.demo_1.product;

/**
 * 按钮抽象类
 * <p>
 * 角色: 抽象产品
 *
 * @author suzailong
 * @date 2022/6/1-3:41 PM
 */
public abstract class AbstractButton {
    public void onClick() {
        System.out.println("basic click");
    }

    /**
     * 声明形状
     *
     * @return shape
     */
   public abstract String generateShape();
}
