package com.codecool.virtual_pet.model;

public enum PetFood {
    MEAT(30),
    JELLY(15),
    BREAD(20),
    MILK(15);

    private double hungerModifier;

    PetFood(double hungerModifier) {
        this.hungerModifier = hungerModifier;
    }

    public double getHungerModifier() {
        return hungerModifier;
    }
}
