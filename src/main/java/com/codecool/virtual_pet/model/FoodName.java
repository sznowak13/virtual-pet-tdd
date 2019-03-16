package com.codecool.virtual_pet.model;

public enum FoodName {
    BREAD("Bread"),
    FAT("Fat"),
    JELLY("Jelly"),
    MEAT("Meat"),
    MILK("Milk"),
    ENERGY_TABS("Energy Tabs"),
    WATER("Water");

    private final String foodName;

    FoodName(String name) {
        foodName = name;
    }

    @Override
    public String toString() {
        return foodName;
    }
}
