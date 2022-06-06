package org.expert.creational.simple_fatory_pattern;

/**
 * 角色: 具体产品
 *
 * @author suzailong
 * @date 2022/6/1-3:50 PM
 */
public class RoundButton extends Button {
    @Override
    String generateShape() {
        return "round";
    }

    @Override
    public void onClick() {
        super.onClick();
        System.out.println("round click ...");
    }
}
