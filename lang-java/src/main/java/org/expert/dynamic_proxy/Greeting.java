package org.expert.dynamic_proxy;

/**
 * 动态代理需要增强的接口
 *
 * @author suzailong
 * @date 2022/5/26-11:11 AM
 */
public interface Greeting {

    /**
     * 打招呼
     */
    String sayHello(String name);


    String sayBye(String name);
}
