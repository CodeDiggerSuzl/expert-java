package org.expert.creational.simple_fatory_not_a_pattern.demo_1.product;

/**
 * @author suzailong
 * @date 2022/6/1-3:50 PM
 */
public class SquareAbstractButton extends AbstractButton {
    @Override
    public String generateShape() {
        return "square";
    }

    @Override
    public void onClick() {
        System.out.println("SquareButton click ...");
    }
}
