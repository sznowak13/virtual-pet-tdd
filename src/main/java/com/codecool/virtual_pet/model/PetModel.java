package com.codecool.virtual_pet.model;

import java.util.ArrayList;
import java.util.List;

public class PetModel {

    private String name;
    private PetStats stats;
    private boolean active;
    private List<Thread> statThreads = new ArrayList<>();
    private boolean sleeping;

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
        if (stats.getHunger() < Config.MAX_STAT_AMOUNT) {
            stats.setHunger(stats.getHunger() + 1);
        }
    }

    public void increaseTiredness() {
        if (stats.getTiredness() < Config.MAX_STAT_AMOUNT) {
            stats.setTiredness(stats.getTiredness() + 1);
        }
    }

    public void decreaseHappiness() {
        if (stats.getHappiness() > Config.MIN_STAT_AMOUNT) {
            stats.setHappiness(stats.getHappiness() - 1);
        }
    }

    private void modifyHappinessBy(double amount) {
        double happinessAfterMod = stats.getHappiness() + amount;
        if (happinessAfterMod > Config.MAX_STAT_AMOUNT) {
            stats.setHappiness(Config.MAX_STAT_AMOUNT);
        } else if (happinessAfterMod < Config.MIN_STAT_AMOUNT) {
            stats.setHappiness(Config.MIN_STAT_AMOUNT);
        } else {
            stats.setHappiness(happinessAfterMod);
        }
    }

    public void feed(PetFood petFood) {
        double modifiedHunger = stats.getHunger() - petFood.getHungerModifier();
        modifyHappinessBy(petFood.getHappinessModifier());
        modifyTirednessBy(petFood.getTirednessModifier());
        if (modifiedHunger > Config.MIN_STAT_AMOUNT) {
            stats.setHunger(modifiedHunger);
        } else {
            stats.setHunger(Config.MIN_STAT_AMOUNT);
        }
    }

    private void modifyTirednessBy(double tirednessModifier) {
        stats.setTiredness(stats.getTiredness() + tirednessModifier);
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
        modifyTirednessBy(-5);
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
