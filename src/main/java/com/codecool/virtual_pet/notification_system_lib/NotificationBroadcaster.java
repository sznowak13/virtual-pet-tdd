package com.codecool.virtual_pet.notification_system_lib;

import java.util.ArrayList;
import java.util.List;

public class NotificationBroadcaster {

    private List<NotificationDispatcher> notificationDispatchers = new ArrayList<>();

    public void broadcast(Notification notification) {
        for (NotificationDispatcher notificationDispatcher : notificationDispatchers) {
            notificationDispatcher.dispatch(notification);
        }
    }

    public void addSubscriber(NotificationDispatcher listener) {
        notificationDispatchers.add(listener);
    }

}
