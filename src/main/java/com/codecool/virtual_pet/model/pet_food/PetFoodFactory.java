package com.codecool.virtual_pet.model.pet_food;

public class PetFoodFactory {

    public static PetFood createFood(FoodName name) {
        switch (name) {
            case BREAD:
                return new PetFood(name, 20, 10, 10);
            case FAT:
                return new PetFood(name, 40, -5, 30);
            case JELLY:
                return new PetFood(name, 15, 15, 5);
            case MEAT:
                return new PetFood(name, 30, 20, 20);
            case MILK:
                return new PetFood(name, 15, 5, 15);
            case ENERGY_TABS:
                return new PetFood(name, 5, -10, -50);
            case WATER:
                return new PetFood(name, 0, 5, -10);
            default:
                throw new IllegalArgumentException("No such food type, or missing implementation.");
        }
    }

}
