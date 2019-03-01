package com.codecool.virtual_pet.view;

import com.codecool.virtual_pet.notification_system_lib.NotificationDispatcher;
import com.codecool.virtual_pet.model.PetModel;
import javafx.scene.layout.BorderPane;

public class PetOverview extends BorderPane {

    private PetView petView = new PetView();
    private PetSummaryView petSummaryView;
    private PetStatsView petStatsView;
    private PetActionsView petActionsView;

    public PetOverview(PetModel petModel) {
        petSummaryView = new PetSummaryView(petModel.getName());
        petStatsView = new PetStatsView(petModel.getStats());
        petActionsView = new PetActionsView();
        setCenter(petView);
        setTop(petSummaryView);
        setLeft(petStatsView);
        setBottom(petActionsView);
    }

    public void addActionNotificationDispatcher(NotificationDispatcher notificationDispatcher) {
        petActionsView.addEventDispatcher(notificationDispatcher);
    }
}
