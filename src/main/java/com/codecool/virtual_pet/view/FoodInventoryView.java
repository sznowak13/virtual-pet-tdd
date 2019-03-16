package com.codecool.virtual_pet.view;

import com.codecool.virtual_pet.model.pet_food.FoodInventory;
import com.codecool.virtual_pet.model.pet_food.PetFood;
import com.codecool.virtual_pet.notification_system_lib.Notification;
import com.codecool.virtual_pet.notification_system_lib.NotificationCode;
import com.codecool.virtual_pet.notification_system_lib.NotificationDispatcher;
import com.codecool.virtual_pet.notification_system_lib.Notifier;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FoodInventoryView extends VBox {

    private GridPane foodGrid = new GridPane();
    private Notifier notifier = new Notifier();
    private Text foodDescription = new Text();

    public FoodInventoryView() {
        super(25);
        setWidth(200);
        foodGrid.setHgap(5);
        foodGrid.setVgap(5);
        setPadding(new Insets(25));
        setAlignment(Pos.CENTER);
        getChildren().addAll(foodGrid, foodDescription);
    }

    void update(FoodInventory inventory) {
        foodGrid.getChildren().clear();
        for (int i = 0; i < inventory.size(); i++) {
            final PetFood food = inventory.get(i);
            FoodIcon icon = new FoodIcon(food, foodDescription);
            icon.setOnMouseClicked(event -> notifier.notify(new Notification(NotificationCode.FEED_PET, food)));
            foodGrid.add(icon, i % 3, i / 3);
        }

    }

    public void addNotificationDispatcher(NotificationDispatcher notificationDispatcher) {
        notifier.addSubscriber(notificationDispatcher);
    }
}
