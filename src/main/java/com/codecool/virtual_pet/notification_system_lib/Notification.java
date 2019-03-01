package com.codecool.virtual_pet.notification_system_lib;

public class Notification {

    private final NotificationCode notificationCode;
    private final Object notificationData;

    public Notification(NotificationCode notificationCode, Object notificationData) {
        this.notificationCode = notificationCode;
        this.notificationData = notificationData;
    }

    public Notification(NotificationCode notificationCode) {
        this(notificationCode, null);
    }

    public NotificationCode getNotificationCode() {
        return notificationCode;
    }

    public Object getNotificationData() {
        return notificationData;
    }
}
