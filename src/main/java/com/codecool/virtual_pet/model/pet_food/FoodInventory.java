package com.codecool.virtual_pet.model.pet_food;

import com.codecool.virtual_pet.model.PetModel;

import java.util.ArrayList;
import java.util.List;

public class FoodInventory {

    private List<PetFood> foodList = new ArrayList<>();

    public void init(PetModel petModel) {
        for (int i = 0; i < 3; i++) {
            foodList.add(PetFoodFactory.createFood(petModel.getDislikedFood()));
        }
        for (int i = 0; i < 4; i++) {
            foodList.add(PetFoodFactory.createFood(FoodName.getRandomFood()));
        }
        foodList.add(PetFoodFactory.createFood(petModel.getFavoriteFood()));
    }

    public void remove(PetFood food) {
        foodList.remove(food);
    }

    public int size() {
        return foodList.size();
    }

    public PetFood get(int i) {
        return foodList.get(i);
    }
}
