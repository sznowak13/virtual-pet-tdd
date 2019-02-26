package com.codecool.virtualPet.View;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PetView extends HBox {

    private ImageView petView = new ImageView();

    public PetView() {
        petView.setImage(new Image(DisplayConfig.PET_IMG_URL));
        petView.setFitWidth(DisplayConfig.PET_DISPLAY_WIDTH);
        petView.setPreserveRatio(true);
        getChildren().add(petView);
    }

}
