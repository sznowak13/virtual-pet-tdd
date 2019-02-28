package com.codecool.virtual_pet.controller;

import com.codecool.virtual_pet.event_system_lib.Event;
import com.codecool.virtual_pet.event_system_lib.EventListener;
import com.codecool.virtual_pet.view.PetSetupView;

public class PetSetupController implements EventListener {

    private PetSetupView petSetupView;

    public PetSetupController(PetSetupView petSetupView) {
        this.petSetupView = petSetupView;
    }

    public PetSetupView getView() {
        return petSetupView;
    }

    @Override
    public void handleEvent(Event event) {
        
    }
}
