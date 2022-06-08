package org.expert.structural.adapter_pattern.class_adapter.demo_1;

/**
 * @author suzailong
 * @date 2022/6/8-3:38 下午
 */
public class Client {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.pluginWithUsb();
    }
}
