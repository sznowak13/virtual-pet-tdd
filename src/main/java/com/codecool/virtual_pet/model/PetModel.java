package com.codecool.virtual_pet.model;

import java.util.ArrayList;
import java.util.List;

public class PetModel {

    private String name;
    private PetStats stats;
    private boolean active;
    private List<Thread> statThreads = new ArrayList<>();
    private boolean sleeping;
    private List<PetFood> favoriteFood = new ArrayList<>();
    private List<PetFood> dislikedFood = new ArrayList<>();

    public PetModel(String name, PetStats petStats) {
        this.name = name;
        stats = petStats;
        active = true;
        sleeping = false;
        statThreads.add(new Thread(new HungerUpdater()));
        statThreads.add(new Thread(new TirednessUpdater()));
        statThreads.add(new Thread(new HappinessUpdater()));
    }

    public PetModel(String name) {
        this(name, new PetStats(50, 50, 50));
    }

    public void start() {
        for (Thread thread : statThreads) {
            thread.start();
        }
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
        modifyHungerBy(-1);
    }

    public void increaseTiredness() {
        modifyTirednessBy(1);
    }

    public void decreaseHappiness() {
        modifyHappinessBy(-1);
    }


    public void setFavoriteFoods(List<PetFood> foodList) {
        favoriteFood = foodList;
    }

    public void setDislikedFoods(List<PetFood> foodList) {
        dislikedFood = foodList;
    }

    private void modifyHungerBy(double amount) {
        double hungerAfterMod = normalizeModification(stats.getHunger() - amount);
        stats.setHunger(hungerAfterMod);
    }

    private void modifyHappinessBy(double amount) {
        double happinessAfterMod = normalizeModification(stats.getHappiness() + amount);
        stats.setHappiness(happinessAfterMod);
    }

    public void feed(PetFood petFood) {
        double favorModifier = getFavorModifier(petFood);
        modifyHungerBy(petFood.getHungerModifier());
        modifyHappinessBy(petFood.getHappinessModifier() + favorModifier);
        modifyTirednessBy(petFood.getTirednessModifier());
    }

    private double getFavorModifier(PetFood petFood) {
        if (favoriteFood.contains(petFood)) {
            return Config.FAVOR_MODIFIER;
        } else if (dislikedFood.contains(petFood)) {
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

    public void stop() {
        for (Thread t : statThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class HungerUpdater implements Runnable {

        @Override
        public void run() {
            while (active) {
                increaseHunger();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class TirednessUpdater implements Runnable {

        @Override
        public void run() {
            while (active) {
                int interval = sleeping ? 300 : 500;
                if (!sleeping) {
                    increaseTiredness();
                } else {
                    rest();
                }
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void rest() {
        modifyTirednessBy(Config.RESTING_MODIFIER);
        if (stats.getTiredness() < 10) {
            sleeping = false;
        }
    }

    private class HappinessUpdater implements Runnable {

        @Override
        public void run() {
            while (active) {
                if (!sleeping) {
                    decreaseHappiness();
                } else {
                    modifyHappinessBy(1);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
