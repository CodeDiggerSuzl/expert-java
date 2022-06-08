package org.expert.behavioral.chain_of_responsibility.demo_1;


import java.util.ArrayList;
import java.util.List;

/**
 * 角色: 基础处理者
 * <p>
 * 一种简单的责任链方法,通过 list 收容所有的 Processor
 * </p>
 *
 * @author suzailong
 * @date 2022/6/8-4:54 下午
 */
public class MsgProcessChain {

    private final List<Procesor> chains = new ArrayList<>();

    public MsgProcessChain addChain(Procesor procesor) {
        chains.add(procesor);
        return this;
    }

    public boolean process(String msg) {

        for (Procesor chain : chains) {
            if (Boolean.FALSE.equals(chain.processMsg(msg))) {
                return false;
            }

        }
        return true;
    }
}
