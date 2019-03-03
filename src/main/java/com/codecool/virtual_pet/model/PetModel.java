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

    public double getHunger() {
        return stats.getHunger();
    }

    public double getTiredness() {
        return stats.getTiredness();
    }

    public double getHappiness() {
        return stats.getHappiness();
    }

    public void increaseHunger() {
        stats.setHunger(stats.getHunger() + 1);
    }

    public void increaseTiredness() {
        stats.setTiredness(stats.getTiredness() + 1);
    }

    public void decreaseHappiness() {
        stats.setHappiness(stats.getHappiness() - 1);
    }

    public void feed(PetFood petFood) {
        stats.setHunger(stats.getHunger() - petFood.getHungerModifier());
    }
}
