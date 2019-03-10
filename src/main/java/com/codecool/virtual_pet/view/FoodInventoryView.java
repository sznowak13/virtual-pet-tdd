package com.codecool.virtual_pet.view;

import com.codecool.virtual_pet.model.PetFood;
import com.codecool.virtual_pet.notification_system_lib.Notification;
import com.codecool.virtual_pet.notification_system_lib.NotificationCode;
import com.codecool.virtual_pet.notification_system_lib.NotificationDispatcher;
import com.codecool.virtual_pet.notification_system_lib.Notifier;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class FoodInventoryView extends GridPane {

    Notifier notifier = new Notifier();

    public FoodInventoryView() {
        super();
        setHgap(5);
        setVgap(5);
    }

    void update(PetFood[] foodList) {
        for (int i = 0; i < foodList.length; i++) {
            Rectangle foodRect = new Rectangle(15, 15);
            final PetFood food = foodList[i];
            foodRect.setOnMouseClicked((event) -> {
                notifier.notify(new Notification(NotificationCode.FEED_PET, food));
                System.out.println("Fed with " + food);
            });
            add(foodRect, i % 3, i / 3);
        }

    }

    public void addNotificationDispatcher(NotificationDispatcher notificationDispatcher) {
        notifier.addSubscriber(notificationDispatcher);
    }
}
