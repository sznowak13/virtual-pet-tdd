package com.codecool.virtual_pet.controller;

import com.codecool.virtual_pet.model.PetModel;
import com.codecool.virtual_pet.view.PetView;

public class PetController {

    private PetModel petModel;
    private PetView petView;

    public PetController() {
        this(new PetModel("Test"), new PetView());
    }

    private PetController(PetModel petModel, PetView petView) {
        this.petModel = petModel;
        this.petView = petView;
    }

    public PetView getPetView() {
        return petView;
    }

    public void setPetView(PetView petView) {
        this.petView = petView;
    }
}
