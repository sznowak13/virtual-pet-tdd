package com.codecool.virtual_pet.controller;

import com.codecool.virtual_pet.view.PetSetupView;

public class PetSetupController {

    private PetSetupView petSetupView;

    public PetSetupController(PetSetupView petSetupView) {
        this.petSetupView = petSetupView;
    }

    public PetSetupView getView() {
        return petSetupView;
    }
}
