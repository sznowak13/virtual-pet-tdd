package com.codecool.virtual_pet.model.stat_updaters;

import com.codecool.virtual_pet.model.PetModel;

public class TirednessUpdater extends StatUpdater {

    public TirednessUpdater(PetModel statSource) {
        super(statSource);
    }

    @Override
    void updateStat() {
        int interval = pet.isSleeping() ? 300 : 500;
        if (!pet.isSleeping()) {
            pet.increaseTiredness();
        } else {
            pet.rest();
        }
        try {
            Thread.sleep(interval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
