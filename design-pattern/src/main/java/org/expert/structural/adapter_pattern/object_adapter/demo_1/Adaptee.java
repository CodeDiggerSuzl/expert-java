package org.expert.structural.adapter_pattern.object_adapter.demo_1;

/**
 * 角色:适配者
 *
 * @author suzailong
 * @date 2022/6/8-2:56 下午
 */
public class Adaptee {
    /**
     * 被适配者的特殊方法 特有方法
     */
    public void specificRequest() {
        System.out.println("can send videos and pics");
    }
}
