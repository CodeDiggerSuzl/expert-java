package org.expert.creational.simple_fatory_pattern;

/**
 * @author suzailong
 * @date 2022/6/1-3:50 PM
 */
public class SquareButton extends Button {
    @Override
    String generateShape() {
        return "square";
    }

    @Override
    public void onClick() {
        System.out.println("SquareButton click ...");
    }
}
