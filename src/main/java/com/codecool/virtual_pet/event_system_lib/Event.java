package com.codecool.virtual_pet.event_system_lib;

public class Event {

    private final EventCode eventCode;
    private final Object eventData;

    public Event(EventCode eventCode, Object eventData) {
        this.eventCode = eventCode;
        this.eventData = eventData;
    }

    public Event(EventCode eventCode) {
        this(eventCode, null);
    }

    public EventCode getEventCode() {
        return eventCode;
    }

    public Object getEventData() {
        return eventData;
    }
}
