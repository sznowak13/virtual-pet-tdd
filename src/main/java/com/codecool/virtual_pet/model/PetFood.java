package com.codecool.virtual_pet.model;

public enum PetFood {
    MEAT(30, 20, 20),
    JELLY(15, 15, 5),
    BREAD(20, 10, 10),
    MILK(15, 5, 15),
    WATER(0, 5, -10),
    FAT(40, -5, 30);

    private double hungerModifier;
    private double happinessModifier;
    private double tirednessModifier;

    PetFood(double hungerModifier, double happinessModifier, double tirednessModifier) {
        this.hungerModifier = hungerModifier;
        this.happinessModifier = happinessModifier;
        this.tirednessModifier = tirednessModifier;
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
}
