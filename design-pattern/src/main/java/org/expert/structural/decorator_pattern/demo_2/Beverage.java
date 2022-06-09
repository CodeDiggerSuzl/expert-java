package org.expert.structural.decorator_pattern.demo_2;

/**
 * 角色:抽象类
 *
 * @author suzailong
 * @date 2022/6/8-11:35 下午
 */
public abstract class Beverage {
    String description = "Unknown beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
    
}
