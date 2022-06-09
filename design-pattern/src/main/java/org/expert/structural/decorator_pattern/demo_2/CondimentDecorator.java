package org.expert.structural.decorator_pattern.demo_2;

/**
 * 角色: 装饰者类
 *
 * @author suzailong
 * @date 2022/6/8-11:37 下午
 */
public abstract class CondimentDecorator extends Drinkable {

    @Override
    public abstract String getDescription();
}
