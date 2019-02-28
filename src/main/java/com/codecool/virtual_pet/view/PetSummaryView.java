package com.codecool.virtual_pet.view;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PetSummaryView extends VBox {

    PetSummaryView(String petName) {
        getChildren().addAll(
                new Label("Pet name:"),
                new Text(petName)
        );
    }
}
