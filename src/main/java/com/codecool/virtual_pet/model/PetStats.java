package com.codecool.virtual_pet.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class PetStats {

    private Map<StatName, Double> stats = new LinkedHashMap<>();

    public PetStats(double hunger, double tiredness, double happiness) {
        stats.put(StatName.HUNGER, hunger);
        stats.put(StatName.TIREDNESS, tiredness);
        stats.put(StatName.HAPPINESS, happiness);
    }

    public double getHunger() {
        return stats.get(StatName.HUNGER);
    }

    public double getTiredness() {
        return stats.get(StatName.TIREDNESS);
    }

    public double getHappiness() {
        return stats.get(StatName.HAPPINESS);
    }
}
