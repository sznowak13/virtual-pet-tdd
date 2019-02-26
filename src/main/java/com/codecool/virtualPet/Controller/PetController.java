package com.codecool.virtualPet.Controller;

import com.codecool.virtualPet.Model.PetModel;
import com.codecool.virtualPet.View.PetView;

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
