package com.codecool.virtual_pet.view;

import com.codecool.virtual_pet.model.pet_food.PetFood;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FoodIcon extends VBox {

    private ImageView foodImage = new ImageView();

    FoodIcon(PetFood food, Text foodDesc) {
        super(5);
        String imgUrl = Util.getFoodImageUrl(food);
        foodImage.setImage(new Image(imgUrl));
        foodImage.setFitWidth(28);
        foodImage.setFitHeight(28);
        setOnMouseEntered(event -> {
            foodImage.setScaleX(1.2);
            foodImage.setScaleY(1.2);
            foodDesc.setText(food.toString());
        });
        setOnMouseExited(event -> {
            foodImage.setScaleY(1);
            foodImage.setScaleX(1);
            foodDesc.setText("");
        });
        getChildren().addAll(foodImage, foodDesc);
    }
}
