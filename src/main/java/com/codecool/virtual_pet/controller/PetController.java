package com.codecool.virtual_pet.controller;

import com.codecool.virtual_pet.notification_system_lib.Notification;
import com.codecool.virtual_pet.notification_system_lib.NotificationHandler;
import com.codecool.virtual_pet.model.PetModel;
import com.codecool.virtual_pet.view.PetOverview;

public class PetController implements NotificationHandler {

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
    public boolean handleNotification(Notification notification) {
        return false;
    }

    public void createPetOverview() {
        setPetView(new PetOverview(petModel));
    }
}
