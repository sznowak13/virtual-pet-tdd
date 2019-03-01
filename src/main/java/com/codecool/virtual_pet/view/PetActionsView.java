package com.codecool.virtual_pet.view;

import com.codecool.virtual_pet.event_system_lib.Event;
import com.codecool.virtual_pet.event_system_lib.EventBroadcaster;
import com.codecool.virtual_pet.event_system_lib.EventCode;
import com.codecool.virtual_pet.event_system_lib.EventDispatcher;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class PetActionsView extends HBox {

    private Button feed = new Button("Feed the pet");
    private Button sleep = new Button("Go to sleep");
    private Button play = new Button("Play with the pet");
    private EventBroadcaster eb = new EventBroadcaster();

    PetActionsView() {
        super(15);
        setupButtonActions();
        getChildren().addAll(
                feed, sleep, play
        );
        setAlignment(Pos.CENTER);
        setPadding(new Insets(30));
    }

    void addEventDispatcher(EventDispatcher eventDispatcher) {
        eb.addSubscriber(eventDispatcher);
    }

    private void setupButtonActions() {
        feed.setOnAction(event -> eb.broadcast(new Event(EventCode.FEED_PET)));
        sleep.setOnAction(event -> eb.broadcast(new Event(EventCode.SLEEP)));
        play.setOnAction(event -> eb.broadcast(new Event(EventCode.PLAY_WITH_PET)));
    }

}
