package com.codecool.virtual_pet.view;

import com.codecool.virtual_pet.model.PetFood;
import com.codecool.virtual_pet.notification_system_lib.Notification;
import com.codecool.virtual_pet.notification_system_lib.Notifier;
import com.codecool.virtual_pet.notification_system_lib.NotificationCode;
import com.codecool.virtual_pet.notification_system_lib.NotificationDispatcher;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class PetActionsView extends HBox {

    private Button feed = new Button("Feed the pet");
    private Button sleep = new Button("Go to sleep");
    private Button play = new Button("Play with the pet");
    private Notifier notifier = new Notifier();

    PetActionsView() {
        super(15);
        setupButtonActions();
        getChildren().addAll(
                feed, sleep, play
        );
        setAlignment(Pos.CENTER);
        setPadding(new Insets(30));
    }

    void addEventDispatcher(NotificationDispatcher notificationDispatcher) {
        notifier.addSubscriber(notificationDispatcher);
    }

    private void setupButtonActions() {
        feed.setOnAction(event -> notifier.notify(new Notification(NotificationCode.OPEN_FOOD_INVENTORY)));
        sleep.setOnAction(event -> notifier.notify(new Notification(NotificationCode.SLEEP)));
        play.setOnAction(event -> notifier.notify(new Notification(NotificationCode.PLAY_WITH_PET)));
    }

}
