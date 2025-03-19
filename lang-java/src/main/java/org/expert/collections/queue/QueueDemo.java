package org.expert.collections.queue;

import lombok.extern.slf4j.Slf4j;
import org.expert.JsonUtil;
import org.junit.Test;

import java.util.PriorityQueue;


@Slf4j
public class QueueDemo {


    @Test
    public void test() {

        //        Queue<Integer> queue = new LinkedList<>();
        //        queue.add(1);
        //        queue.add(2);
        //        log.info(queue.toString());
        //        Integer poll = queue.poll();
        //        System.out.println(queue.peek());

        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        pQ.add(3);
        //        pQ.add(1);
        pQ.add(2);
        log.info(JsonUtil.toJson(pQ));
        System.out.println("pQ.peek() = " + pQ.peek());
    }


}
