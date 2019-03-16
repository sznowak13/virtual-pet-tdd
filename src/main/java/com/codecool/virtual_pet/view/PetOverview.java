package com.codecool.virtual_pet.view;

import com.codecool.virtual_pet.model.FoodName;
import com.codecool.virtual_pet.model.PetFood;
import com.codecool.virtual_pet.model.PetStats;
import com.codecool.virtual_pet.notification_system_lib.NotificationDispatcher;
import com.codecool.virtual_pet.model.PetModel;
import javafx.scene.layout.BorderPane;

public class PetOverview extends BorderPane {

    private PetView petView = new PetView();
    private PetSummaryView petSummaryView;
    private PetStatsView petStatsView;
    private PetActionsView petActionsView;
    private FoodInventoryView foodInventory;

    public PetOverview(PetModel petModel) {
        petSummaryView = new PetSummaryView(petModel.getName());
        petStatsView = new PetStatsView(petModel.getStats());
        petActionsView = new PetActionsView();
        foodInventory = new FoodInventoryView();
        setCenter(petView);
        setTop(petSummaryView);
        setLeft(petStatsView);
        setBottom(petActionsView);
    }

    public void addActionNotificationDispatcher(NotificationDispatcher notificationDispatcher) {
        petActionsView.addEventDispatcher(notificationDispatcher);
        foodInventory.addNotificationDispatcher(notificationDispatcher);
    }


    public void updateStats(PetStats stats) {
        petStatsView.updateHunger(stats.getHunger());
        petStatsView.updateTiredness(stats.getTiredness());
        petStatsView.updateHappiness(stats.getHappiness());
    }

    public void openFoodInventory(PetFood[] values) {
        foodInventory.update(values);
        setRight(foodInventory);
    }

    public void updateThoughts(PetModel petModel) {
        petSummaryView.update(petModel);
    }
}
