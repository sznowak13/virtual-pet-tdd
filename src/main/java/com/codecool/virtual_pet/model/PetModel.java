package com.codecool.virtual_pet.model;

public class PetModel {

    private String name;
    private PetStats stats;

    public PetModel(String name, PetStats petStats) {
        this.name = name;
        stats = petStats;
    }

    public PetModel(String name) {
        this(name, new PetStats(50, 50, 50));
    }

    public String getName() {
        return name;
    }

    public PetStats getStats() {
        return stats;
    }

    public int getHunger() {
        return stats.getHunger();
    }

    public int getTireness() {
        return stats.getTireness();
    }

    public int getHappiness() {
        return stats.getHappiness();
    }
}
