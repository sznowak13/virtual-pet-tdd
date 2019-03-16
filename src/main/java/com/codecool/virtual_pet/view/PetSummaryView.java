package com.codecool.virtual_pet.view;

import com.codecool.virtual_pet.model.PetModel;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PetSummaryView extends VBox {

    private Text petThoughtsView = new Text();
    private Text dislikedFood = new Text();
    private Text favoriteFood = new Text();

    PetSummaryView(String petName) {
        super(15);
        getChildren().addAll(
                new Label("Pet name:"),
                new Text(petName),
                petThoughtsView,
                favoriteFood,
                dislikedFood
        );
        setAlignment(Pos.CENTER);
    }

    public void update(PetModel petModel) {
        petThoughtsView.setText(petModel.getPetThoughts());
        dislikedFood.setText(petModel.getDislikedFood().toString());
        favoriteFood.setText(petModel.getFavoriteFood().toString());
    }
}
