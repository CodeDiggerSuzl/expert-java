package org.expert.behavioral.chain_of_responsibility.demo_2;

/**
 * 具体处理器
 *
 * @author suzailong
 * @date 2022/6/8-10:29 下午
 */
public class SpamHandler extends AbstractHandler {

    public SpamHandler(AbstractHandler next) {
        super(next);
    }

    public SpamHandler() {

    }

    @Override
    public void handle(String request) {
        System.out.println("spam handler processing");
        if (this.next != null) {
            this.next.handle(request);
        }
    }
}
