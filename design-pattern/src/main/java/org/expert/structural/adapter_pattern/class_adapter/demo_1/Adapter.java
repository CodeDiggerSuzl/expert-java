package org.expert.structural.adapter_pattern.class_adapter.demo_1;

/**
 * 适配器
 *
 * @author suzailong
 * @date 2022/6/8-3:35 下午
 */
public class Adapter extends TypeCMacBook implements UsbMouse {

    @Override
    public void pluginWithUsb() {
        System.out.println("input in with usb");
        super.plugInWithTypeC();
    }
}
