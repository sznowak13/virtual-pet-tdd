package com.codecool.virtual_pet.view;

import com.codecool.virtual_pet.notification_system_lib.Notification;
import com.codecool.virtual_pet.notification_system_lib.NotificationBroadcaster;
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
    private NotificationBroadcaster eb = new NotificationBroadcaster();

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
        eb.addSubscriber(notificationDispatcher);
    }

    private void setupButtonActions() {
        feed.setOnAction(event -> eb.broadcast(new Notification(NotificationCode.FEED_PET)));
        sleep.setOnAction(event -> eb.broadcast(new Notification(NotificationCode.SLEEP)));
        play.setOnAction(event -> eb.broadcast(new Notification(NotificationCode.PLAY_WITH_PET)));
    }

}
