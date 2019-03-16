package com.codecool.virtual_pet.model.stat_updaters;

import com.codecool.virtual_pet.model.PetModel;

public class HungerUpdater extends StatUpdater {

    public HungerUpdater(PetModel statSource) {
        super(statSource);
    }

    @Override
    void updateStat() {
        pet.increaseHunger();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
