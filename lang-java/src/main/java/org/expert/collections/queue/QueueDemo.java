package org.expert.collections.queue;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.expert.JsonUtil;
import org.junit.Test;

import java.util.Date;
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
        System.out.println(JsonUtil.toJson(pQ));
        System.out.println("pQ.peek() = " + pQ.peek());
        Date date = new Date();
        Date date1 = DateUtils.addDays(date, 158);
        System.out.println("date = " + date1.getTime());
    }

    @Data
    static class CycleInfo {
        private final Integer cycleNumber;  // 当前周期数,null表示超过范围
        private final Date cycleStart;      // 当前周期开始时间
        private final Date cycleEnd;        // 当前周期结束时间
    }


}
