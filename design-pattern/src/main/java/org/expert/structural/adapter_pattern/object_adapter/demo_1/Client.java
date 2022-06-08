package org.expert.structural.adapter_pattern.object_adapter.demo_1;

/**
 * Client
 * <p></p>
 * <p>
 * 对象适配器: 适配器持有一个需要被适配的实例, client 先申请创建一个 adaptee 的实例
 * </p>
 *
 * @author suzailong
 * @date 2022/6/8-3:06 下午
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("--".repeat(10));

        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);
        adapter.request();

        System.out.println("--".repeat(10));
    }
}
