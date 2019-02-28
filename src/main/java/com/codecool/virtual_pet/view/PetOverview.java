package com.codecool.virtual_pet.view;

import com.codecool.virtual_pet.model.PetModel;
import javafx.scene.layout.BorderPane;

public class PetOverview extends BorderPane {

    private PetView petView = new PetView();
    private PetSummaryView petSummaryView;
    private PetStatsView petStatsView;

    public PetOverview(PetModel petModel) {
        petSummaryView = new PetSummaryView(petModel.getName());
        petStatsView = new PetStatsView(petModel.getStats());
        setCenter(petView);
        setTop(petSummaryView);
        setLeft(petStatsView);
    }
}
