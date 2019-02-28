package com.codecool.virtual_pet.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class PetStats {

    private Map<StatName, Integer> stats = new LinkedHashMap<>();

    public PetStats(int hunger, int tiredness, int happiness) {
        stats.put(StatName.HUNGER, hunger);
        stats.put(StatName.TIREDNESS, tiredness);
        stats.put(StatName.HAPPINESS, happiness);
    }

    public int getHunger() {
        return stats.get(StatName.HUNGER);
    }

    public int getTireness() {
        return stats.get(StatName.TIREDNESS);
    }

    public int getHappiness() {
        return stats.get(StatName.HAPPINESS);
    }
}
