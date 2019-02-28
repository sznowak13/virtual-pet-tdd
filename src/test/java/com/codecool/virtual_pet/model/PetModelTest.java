package com.codecool.virtual_pet.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetModelTest {

    private PetModel petModel = new PetModel("Test");

    @Test
    void constructor() {
        petModel = new PetModel("Testing constructor", new PetStats(100, 50, 80));
        assertEquals(petModel.getHunger(), 100);
        assertEquals(petModel.getHappiness(), 80);
        assertEquals(petModel.getTireness(), 50);
    }
}