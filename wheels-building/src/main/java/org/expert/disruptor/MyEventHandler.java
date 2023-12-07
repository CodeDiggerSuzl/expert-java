package org.expert.disruptor;

import com.lmax.disruptor.EventHandler;

public class MyEventHandler implements EventHandler<MyEvent> {

    @Override
    public void onEvent(MyEvent myEvent, long l, boolean b) throws Exception {
        System.out.println("MyEventHandler.onEvent");
        System.out.println(myEvent);
    }
}
