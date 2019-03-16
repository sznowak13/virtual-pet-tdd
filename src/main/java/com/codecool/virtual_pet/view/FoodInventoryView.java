package com.codecool.virtual_pet.view;

import com.codecool.virtual_pet.model.PetFood;
import com.codecool.virtual_pet.notification_system_lib.Notification;
import com.codecool.virtual_pet.notification_system_lib.NotificationCode;
import com.codecool.virtual_pet.notification_system_lib.NotificationDispatcher;
import com.codecool.virtual_pet.notification_system_lib.Notifier;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FoodInventoryView extends VBox {

    private GridPane foodGrid = new GridPane();
    private Notifier notifier = new Notifier();
    private Text foodDescription = new Text();

    public FoodInventoryView() {
        super();
        setHgap(5);
        setVgap(5);
    }

    void update(PetFood[] foodList) {
        for (int i = 0; i < foodList.length; i++) {
            final PetFood food = foodList[i];
            FoodIcon icon = new FoodIcon(food, foodDescription);
            icon.setOnMouseClicked(event -> notifier.notify(new Notification(NotificationCode.FEED_PET, food)));
            foodGrid.add(icon, i % 3, i / 3);
        }

    }

    public void addNotificationDispatcher(NotificationDispatcher notificationDispatcher) {
        notifier.addSubscriber(notificationDispatcher);
    }
}
