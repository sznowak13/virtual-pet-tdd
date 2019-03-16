package com.codecool.virtual_pet.model;

public class PetFood {

    private final FoodName name;
    private final double hungerModifier;
    private final double happinessModifier;
    private final double tirednessModifier;

    PetFood(FoodName name, double hungerModifier, double happinessModifier, double tirednessModifier) {
        this.name = name;
        this.hungerModifier = hungerModifier;
        this.happinessModifier = happinessModifier;
        this.tirednessModifier = tirednessModifier;
    }

    public FoodName getName() {
        return name;
    }

    public double getHungerModifier() {
        return hungerModifier;
    }

    public double getHappinessModifier() {
        return happinessModifier;
    }

    public double getTirednessModifier() {
        return tirednessModifier;
    }

    @Override
    public String toString() {
        return getName().toString();
    }

    public static PetFood getRandomFood() {
        return null;
    }
}
