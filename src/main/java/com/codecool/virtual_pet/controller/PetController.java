package com.codecool.virtual_pet.controller;

import com.codecool.virtual_pet.event_system_lib.Event;
import com.codecool.virtual_pet.event_system_lib.EventHandler;
import com.codecool.virtual_pet.model.PetModel;
import com.codecool.virtual_pet.view.PetOverview;
import com.codecool.virtual_pet.view.PetSummaryView;
import com.codecool.virtual_pet.view.PetView;

public class PetController implements EventHandler {

    private PetModel petModel;
    private PetOverview petView;

    public PetController() {
        this(new PetModel("Test"));
    }

    public PetController(PetModel petModel) {
        this.petModel = petModel;
    }

    public PetOverview getPetView() {
        return petView;
    }

    public void setPetView(PetOverview petView) {
        this.petView = petView;
    }

    @Override
    public boolean handleEvent(Event event) {
        return false;
    }

    public void createPetOverview() {
        setPetView(new PetOverview(petModel));
    }
}
