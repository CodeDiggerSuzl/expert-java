package org.expert.behavioral.chain_of_responsibility.demo_2;

/**
 * @author suzailong
 * @date 2022/6/8-10:35 下午
 */
public class ComplaintHandler extends AbstractHandler {

    public ComplaintHandler(AbstractHandler next) {
        super(next);
    }

    public ComplaintHandler() {

    }

    @Override
    public void handle(String request) {
        System.out.println("complaint handler processing");
        if (this.next != null) {
            this.next.handle(request);
        }
    }
}
