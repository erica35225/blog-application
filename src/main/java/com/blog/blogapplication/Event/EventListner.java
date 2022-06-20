package com.blog.blogapplication.Event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class EventListner {
    @Async
    @EventListener
    public void handleEvent(UserAddedEvent event) {
        System.err.println("this is the user -- >>> "+event.getPayload().getName() +" and she is "+ event.getPayload().getAbout());
    }
}
