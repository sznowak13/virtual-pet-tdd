package com.codecool.virtual_pet.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PetModelTest {

    private PetModel petModel = new PetModel("Testing", new PetStats(15, 30, 80));

    @Test
    void constructor() {
        assertEquals(petModel.getName(), "Testing");
        assertEquals(petModel.getHunger(), 15);
        assertEquals(petModel.getHappiness(), 80);
        assertEquals(petModel.getTiredness(), 30);
    }

    @Test
    void happinessDecrease() {
        // decreasing  once
        petModel.decreaseHappiness();
        assertEquals(petModel.getHappiness(), 79);
        // and 50 times more
        for (int i = 0; i < 50; i ++) {
            petModel.decreaseHappiness();
        }
        assertEquals(29, petModel.getHappiness());
    }

    @Test
    void tirednessAndHungerIncreases() {
        petModel.increaseHunger();
        petModel.increaseTiredness();
        assertEquals(16, petModel.getHunger());
        assertEquals(31, petModel.getTiredness());
        for (int i = 0; i < 50; i++) {
            petModel.increaseHunger();
            petModel.increaseTiredness();
        }
        assertEquals(66, petModel.getHunger());
        assertEquals(81, petModel.getTiredness());
    }

    @Test
    void decreaseHungerAfterFeeding() {
        petModel.getStats().setHunger(80);
        petModel.feed(PetFood.MEAT);
        assertEquals(50, petModel.getHunger());
    }

    @ParameterizedTest
    @EnumSource(PetFood.class)
    void hungerDecreasesDependingOnFoodType(PetFood food) {
        petModel.getStats().setHunger(100);
        petModel.feed(food);
        assertEquals(100 - food.getHungerModifier(), petModel.getHunger());
    }

    @ParameterizedTest
    @EnumSource(PetFood.class)
    void happinessChangesDependingOnFoodType(PetFood food) {
        petModel.getStats().setHappiness(50);
        petModel.feed(food);
        assertEquals(50 + food.getHappinessModifier(), petModel.getHappiness());
    }

    @Test
    void happinessCannotDropBelowZero() {
        petModel.getStats().setHappiness(3);
        petModel.feed(PetFood.FAT); // Fat has negative happiness modifier
        assertEquals(0, petModel.getHappiness());
    }

    @Test
    void happinessCannotRaiseAbove100() {
        petModel.getStats().setHappiness(95);
        petModel.feed(PetFood.BREAD); // raising happiness by 10
        assertEquals(100, petModel.getHappiness());
    }

    @Test
    void tirednessCannotDropBelowZero() {
        petModel.getStats().setTiredness(5);
        petModel.feed(PetFood.ENERGY_TABS); // reduces tiredness by 50
        assertEquals(0, petModel.getTiredness());
    }

    @Test
    void tirednessCannotRaiseAbove100() {
        petModel.getStats().setTiredness(90);
        petModel.feed(PetFood.FAT); // increases tiredness by 30
        assertEquals(100, petModel.getTiredness());
    }

    @Test
    void reactsToFavoriteFoodCorrectly() {
        petModel.getStats().setHappiness(0);
        petModel.setFavoriteFoods(Arrays.asList(PetFood.MEAT));
        petModel.feed(PetFood.MEAT);
        assertEquals(30, petModel.getHappiness());
    }

    @Test
    void reactsToDislikedFoodCorrectly() {
        petModel.getStats().setHappiness(30);
        petModel.setDislikedFoods(Arrays.asList(PetFood.ENERGY_TABS));
        petModel.feed(PetFood.ENERGY_TABS);
        assertEquals(10, petModel.getHappiness());
    }
}