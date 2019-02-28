package com.codecool.virtual_pet.controller;

import com.codecool.virtual_pet.event_system_lib.Event;
import com.codecool.virtual_pet.event_system_lib.EventHandler;
import com.codecool.virtual_pet.model.PetModel;
import com.codecool.virtual_pet.view.PetView;

public class PetController implements EventHandler {

    private PetModel petModel;
    private PetView petView;

    public PetController() {
        this(new PetModel("Test"), new PetView());
    }

    public PetController(PetModel petModel, PetView petView) {
        this.petModel = petModel;
        this.petView = petView;
    }

    public PetView getPetView() {
        return petView;
    }

    public void setPetView(PetView petView) {
        this.petView = petView;
    }

    @Override
    public boolean handleEvent(Event event) {
        return false;
    }
}
