package org.expert.structural.adapter_pattern.object_adapter.demo_1;

/**
 * 角色: 适配器
 *
 * @author suzailong
 * @date 2022/6/8-3:02 下午
 */
public class Adapter extends Target {

    private final Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        System.out.println("send common request, extends from Target");
        adaptee.specificRequest();
    }
}
