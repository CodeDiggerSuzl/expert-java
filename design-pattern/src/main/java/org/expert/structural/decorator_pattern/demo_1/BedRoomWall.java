package org.expert.structural.decorator_pattern.demo_1;

/**
 * 角色: 具体的构件
 *
 * @author suzailong
 * @date 2022/6/8-6:48 下午
 */
public class BedRoomWall extends AbstractWall {
    @Override
    public void desc() {
        System.out.println("just a plain wall, with nothing on it");
    }
}
