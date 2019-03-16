package com.codecool.virtual_pet.model;

import com.codecool.virtual_pet.model.stat_updaters.HappinessUpdater;
import com.codecool.virtual_pet.model.stat_updaters.HungerUpdater;
import com.codecool.virtual_pet.model.stat_updaters.TirednessUpdater;

import java.util.ArrayList;
import java.util.List;

public class PetModel {

    private String name;
    private PetStats stats;
    private boolean active;
    private List<Thread> statThreads = new ArrayList<>();
    private boolean sleeping;
    private FoodName favoriteFood;
    private FoodName dislikedFood;
    private String petThoughts;

    public PetModel(String name, PetStats petStats) {
        this.name = name;
        stats = petStats;
        active = true;
        sleeping = false;
        statThreads.add(new Thread(new HungerUpdater(this)));
        statThreads.add(new Thread(new TirednessUpdater(this)));
        statThreads.add(new Thread(new HappinessUpdater(this)));
    }

    public PetModel(String name) {
        this(name, new PetStats(50, 50, 50));
    }

    public void start() {
        for (Thread thread : statThreads) {
            thread.start();
        }
        petThoughts = "Hi! My name is " + name + "!";
    }

    public String getName() {
        return name;
    }

    public String getPetThoughts() {
        return petThoughts;
    }

    public FoodName getFavoriteFood() {
        return favoriteFood;
    }

    public FoodName getDislikedFood() {
        return dislikedFood;
    }

    public void setFoodTaste(FoodName favoriteFood, FoodName dislikedFood) {
        if (favoriteFood != null) {
            this.favoriteFood = favoriteFood;
        }
        if (dislikedFood != null) {
            this.dislikedFood = dislikedFood;
        }
    }

    public synchronized PetStats getStats() {
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
        if (sleeping) {
            modifyHungerBy(-5);
        } else {
            modifyHungerBy(-1);
        }
    }

    public void increaseTiredness() {
        modifyTirednessBy(1);
    }

    public void decreaseHappiness() {
        modifyHappinessBy(-1);
    }


    public void setFavoriteFoods(FoodName foodName) {
        favoriteFood = foodName;
    }

    public void setDislikedFoods(FoodName foodName) {
        dislikedFood = foodName;
    }

    private void modifyHungerBy(double amount) {
        double hungerAfterMod = normalizeModification(stats.getHunger() - amount);
        stats.setHunger(hungerAfterMod);
    }

    public void modifyHappinessBy(double amount) {
        double happinessAfterMod = normalizeModification(stats.getHappiness() + amount);
        stats.setHappiness(happinessAfterMod);
    }

    public void feed(PetFood petFood) {
        double favorModifier = getFavorModifier(petFood);
        if (favorModifier > 0) {
            petThoughts = "Yummy! I like " + petFood + "!";
        } else if (favorModifier < 0) {
            petThoughts = "Yuk! That's not what I wanted :C";
        } else {
            petThoughts = "Omnomnomnomnom. That's ok.";
        }
        modifyHungerBy(petFood.getHungerModifier());
        modifyHappinessBy(petFood.getHappinessModifier() + favorModifier);
        modifyTirednessBy(petFood.getTirednessModifier());
        System.out.println("Fed with " + petFood);
    }

    private double getFavorModifier(PetFood petFood) {
        if (favoriteFood != null && favoriteFood.equals(petFood.getName())) {
            return Config.FAVOR_MODIFIER;
        } else if (dislikedFood != null && dislikedFood.equals(petFood.getName())) {
            return -Config.FAVOR_MODIFIER;
        } else {
            return 0;
        }
    }

    private void modifyTirednessBy(double tirednessModifier) {
        double modifiedTiredness = normalizeModification(stats.getTiredness() + tirednessModifier);
        stats.setTiredness(modifiedTiredness);
    }

    private double normalizeModification(double modification) {
        if (modification > Config.MAX_STAT_AMOUNT) {
            return Config.MAX_STAT_AMOUNT;
        } else if (modification < Config.MIN_STAT_AMOUNT) {
            return Config.MIN_STAT_AMOUNT;
        } else {
            return modification;
        }
    }

    public void setSleeping(boolean b) {
        sleeping = b;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isSleeping() {
        return sleeping;
    }

    public void stop() {
        for (Thread t : statThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void rest() {
        modifyTirednessBy(Config.RESTING_MODIFIER);
        petThoughts = "Night night, need some rest...";
        if (stats.getTiredness() < 10) {
            sleeping = false;
            petThoughts = "Time to wake up! Feelin' alive!";
        }
    }
}
