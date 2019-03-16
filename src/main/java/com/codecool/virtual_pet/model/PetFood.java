package com.codecool.virtual_pet.model;

public enum PetFood {
    BREAD(20, 10, 10),
    FAT(40, -5, 30),
    JELLY(15, 15, 5),
    MEAT(30, 20, 20),
    MILK(15, 5, 15),
    ENERGY_TABS(5, -10, -50),
    WATER(0, 5, -10);

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

    public static PetFood getRandomFood() {
        PetFood[] foods = PetFood.values();
        int randomIndex = (int) (Math.random() * foods.length);
        return foods[randomIndex];
    }
}
