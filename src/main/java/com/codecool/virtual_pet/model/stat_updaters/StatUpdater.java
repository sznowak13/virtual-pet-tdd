package com.codecool.virtual_pet.model.stat_updaters;

import com.codecool.virtual_pet.model.PetModel;

public abstract class StatUpdater implements Runnable {

    PetModel pet;

    StatUpdater(PetModel statSource) {
        pet = statSource;
    }

    abstract void updateStat();

    @Override
    public void run() {
        while (pet.isActive()) {
            updateStat();
        }
    }
}
