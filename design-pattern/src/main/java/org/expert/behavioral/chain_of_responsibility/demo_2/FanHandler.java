package org.expert.behavioral.chain_of_responsibility.demo_2;

/**
 * 粉丝邮件处理器
 *
 * @author suzailong
 * @date 2022/6/8-10:34 下午
 */
public class FanHandler extends AbstractHandler {

    public FanHandler(AbstractHandler next) {
        super(next);
    }

    public FanHandler() {
        super();
    }

    @Override
    public void handle(String request) {
        System.out.println("fan handler handling request = " + request);

        if (this.next != null) {
            this.next.handle(request);
        }
    }
}
