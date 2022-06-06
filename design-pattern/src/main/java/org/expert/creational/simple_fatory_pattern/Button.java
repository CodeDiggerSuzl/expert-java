package org.expert.creational.simple_fatory_pattern;

/**
 * 按钮抽象类
 * <p>
 * 角色: 抽象产品
 *
 * @author suzailong
 * @date 2022/6/1-3:41 PM
 */
public abstract class Button {
    public void onClick() {
        System.out.println("basic click");
    }

    /**
     * 声明形状
     *
     * @return shape
     */
    abstract String generateShape();
}
