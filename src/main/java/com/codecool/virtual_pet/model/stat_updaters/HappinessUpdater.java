package com.codecool.virtual_pet.model.stat_updaters;

import com.codecool.virtual_pet.model.PetModel;

public class HappinessUpdater extends StatUpdater{

    public HappinessUpdater(PetModel statSource) {
        super(statSource);
    }

    @Override
    void updateStat() {
        if (!pet.isSleeping()) {
            pet.decreaseHappiness();
        } else {
            pet.modifyHappinessBy(1);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
