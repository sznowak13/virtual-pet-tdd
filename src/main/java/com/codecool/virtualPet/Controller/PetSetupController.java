package com.codecool.virtualPet.Controller;

import com.codecool.virtualPet.View.PetSetupView;

public class PetSetupController {

    private PetSetupView petSetupView;

    public PetSetupController(PetSetupView petSetupView) {
        this.petSetupView = petSetupView;
    }

    public PetSetupView getView() {
        return petSetupView;
    }
}
