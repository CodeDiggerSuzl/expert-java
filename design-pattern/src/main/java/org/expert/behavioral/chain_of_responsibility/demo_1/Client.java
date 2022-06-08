package org.expert.behavioral.chain_of_responsibility.demo_1;


import cn.hutool.core.util.RandomUtil;

import java.io.IOException;

/**
 * @author suzailong
 * @date 2022/6/8-5:17 下午
 */
public class Client {
    public static void main(String[] args) throws IOException {
        String s = RandomUtil.randomString(20);
        String damn = "damn";
        MsgProcessChain chain = new MsgProcessChain()
                .addChain(new LenProcessor())
                .addChain(new SensitiveWordProcessor());

        System.out.println("chain.process(s) = " + chain.process(s));
        System.out.println("--".repeat(10));
        System.out.println("chain.process(damn) = " + chain.process(damn));


    }
}
