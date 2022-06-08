package org.expert.behavioral.chain_of_responsibility.demo_1;

import org.assertj.core.util.Strings;

/**
 * 角色:具体处理者
 *
 * @author suzailong
 * @date 2022/6/8-4:44 下午
 */
public class LenProcessor implements Procesor {

    @Override
    public boolean processMsg(String msg) {
        if (Strings.isNullOrEmpty(msg)) {
            return false;
        }
        System.out.println("[len processor] processing ==> msg" + msg);
        return msg.length() <= 5;
    }
}
