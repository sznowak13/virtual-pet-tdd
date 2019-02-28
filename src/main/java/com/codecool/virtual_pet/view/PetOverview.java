package com.codecool.virtual_pet.view;

import com.codecool.virtual_pet.model.PetModel;
import javafx.scene.layout.BorderPane;

public class PetOverview extends BorderPane {

    private PetView petView = new PetView();
    private PetSummaryView petSummaryView;

    public PetOverview(PetModel petModel) {
        petSummaryView = new PetSummaryView(petModel.getName());
        setCenter(petView);
        setTop(petSummaryView);
    }
}
