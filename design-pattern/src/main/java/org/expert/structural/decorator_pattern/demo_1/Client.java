package org.expert.structural.decorator_pattern.demo_1;

/**
 * 角色: client
 *
 * @author suzailong
 * @date 2022/6/8-7:00 下午
 */
public class Client {
    public static void main(String[] args) {
        AbstractWall wall = new BedRoomWall();
        PainterDecorator decorator = new PainterDecorator(wall);
        decorator.paintOnWall();
    }
}
