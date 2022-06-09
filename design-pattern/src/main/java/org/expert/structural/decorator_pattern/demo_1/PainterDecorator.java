package org.expert.structural.decorator_pattern.demo_1;

/**
 * 具体装饰类
 *
 * @author suzailong
 * @date 2022/6/8-6:58 下午
 */
public class PainterDecorator extends Decorator {

    public PainterDecorator(AbstractWall wall) {
        super(wall);
    }

    public void paintOnWall() {
        super.desc();
        System.out.println("painter painting a pic on the wall");
    }
}
