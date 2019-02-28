package com.codecool.virtual_pet.controller;

import com.codecool.virtual_pet.event_system_lib.Event;
import com.codecool.virtual_pet.event_system_lib.EventHandler;
import com.codecool.virtual_pet.view.PetSetupView;

public class PetSetupController implements EventHandler {

    private PetSetupView petSetupView;

    public PetSetupController(PetSetupView petSetupView) {
        this.petSetupView = petSetupView;
    }

    public PetSetupView getView() {
        return petSetupView;
    }

    @Override
    public boolean handleEvent(Event event) {
        String petName = event.getEventData().toString();
        if (petName.length() > 0) {
            return true;
        } else {
            displayError("Pet name cannot be blank!");
            return false;
        }
    }

    private void displayError(String error) {
        petSetupView.displayError(error);
    }
}
