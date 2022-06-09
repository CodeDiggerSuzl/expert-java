package org.expert.structural.decorator_pattern.demo_1;

/**
 * 装饰类
 *
 * @author suzailong
 * @date 2022/6/8-6:55 下午
 */
public class Decorator extends AbstractWall {

    private final AbstractWall wall;

    public Decorator(AbstractWall wall) {
        this.wall = wall;
    }

    @Override
    void desc() {
        wall.desc();
    }
}
