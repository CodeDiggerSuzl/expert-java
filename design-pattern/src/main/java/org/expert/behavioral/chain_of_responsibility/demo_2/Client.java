package org.expert.behavioral.chain_of_responsibility.demo_2;

/**
 * @author suzailong
 * @date 2022/6/8-10:36 下午
 */
public class Client {
    public static void main(String[] args) {
        AbstractHandler fanHandler = new FanHandler();

        AbstractHandler spamHandler = new SpamHandler();
        AbstractHandler complaintHandler = new ComplaintHandler();

        fanHandler.setNext(spamHandler);
        spamHandler.setNext(complaintHandler);

        fanHandler.handle("test");

    }
}
