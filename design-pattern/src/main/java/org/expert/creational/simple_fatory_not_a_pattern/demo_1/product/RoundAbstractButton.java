package org.expert.creational.simple_fatory_not_a_pattern.demo_1.product;

/**
 * 角色: 具体产品
 *
 * @author suzailong
 * @date 2022/6/1-3:50 PM
 */
public class RoundAbstractButton extends AbstractButton {
    @Override
    public String generateShape() {
        return "round";
    }

    @Override
    public void onClick() {
        super.onClick();
        System.out.println("round click ...");
    }
}
