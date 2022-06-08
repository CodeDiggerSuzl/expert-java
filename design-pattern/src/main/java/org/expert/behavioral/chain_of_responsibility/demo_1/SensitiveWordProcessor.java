package org.expert.behavioral.chain_of_responsibility.demo_1;

/**
 * @author suzailong
 * @date 2022/6/8-4:44 下午
 */
public class SensitiveWordProcessor implements Procesor {
    @Override
    public boolean processMsg(String msg) {
        System.out.println("[sensitive word processor] processing msg");
        return !"damn".equals(msg);
    }
}
