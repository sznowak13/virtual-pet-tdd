package com.codecool.virtual_pet.event_system_lib;

import java.util.ArrayList;
import java.util.List;

public class EventBroadcaster {

    private List<EventDispatcher> eventDispatchers = new ArrayList<>();

    public void broadcast(Event event) {
        for (EventDispatcher eventDispatcher : eventDispatchers) {
            eventDispatcher.dispatch(event);
        }
    }

    public void addSubscriber(EventDispatcher listener) {
        eventDispatchers.add(listener);
    }

}
