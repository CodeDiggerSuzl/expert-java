package org.expert.behavioral.chain_of_responsibility.demo_1;


/**
 * 执行处理的公共接口
 * <p>
 * 角色: 抽象的处理者
 *
 * @author suzailong
 * @date 2022/6/8-4:38 下午
 */
public interface Procesor {

    boolean processMsg(String msg);
}
