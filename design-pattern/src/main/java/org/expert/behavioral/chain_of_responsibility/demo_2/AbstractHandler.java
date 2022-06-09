package org.expert.behavioral.chain_of_responsibility.demo_2;

/**
 * 角色: 抽象的处理方法
 *
 * @author suzailong
 * @date 2022/6/8-10:26 下午
 */
public abstract class AbstractHandler {

    protected AbstractHandler next;

    public AbstractHandler(AbstractHandler next) {
        this.next = next;
    }


    public void setNext(AbstractHandler next) {
        this.next = next;
    }

    public AbstractHandler() {
    }

    public abstract void handle(String request);
}
