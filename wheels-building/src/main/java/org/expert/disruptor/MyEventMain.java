package org.expert.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.nio.ByteBuffer;

public class MyEventMain {

    public static void main(String[] args) throws InterruptedException {
        int bufferSize = 2;
        Disruptor<MyEvent> disruptor =
                new Disruptor<>(
                        new MyEventFactory(),
                        bufferSize,
                        DaemonThreadFactory.INSTANCE,
                        ProducerType.SINGLE,
                        new BlockingWaitStrategy());
        disruptor.handleEventsWith(new MyEventHandler());
        disruptor.start();

        RingBuffer<MyEvent> ringBuffer = disruptor.getRingBuffer();
        ByteBuffer bb = ByteBuffer.allocate(8);
        long l = 0;
        while (true) {
            bb.putLong(0, l);
            ringBuffer.publishEvent((event, sequence, buffer) -> event.setData(buffer.getLong(0)), bb);
            Thread.sleep(1000);
            l++;
        }

    }
}
