package org.expert.dynamic_proxy;

import org.expert.JsonUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理测试
 *
 * @author suzailong
 * @date 2022/5/26-11:13 AM
 */
public class DynamicProxyTest {


    public static void main(String[] args) {
        final Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(Greeting.class.getClassLoader(), new Class[]{Greeting.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                final String name = method.getName();

                System.out.println(JsonUtil.toJson(args));


                return "..." + args[0];
            }
        });

        final String greetingMsg = proxyInstance.sayHello("Peter");

        System.out.println(greetingMsg);
    }
}
