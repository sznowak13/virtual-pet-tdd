package com.codecool.virtual_pet.controller;

import com.codecool.virtual_pet.notification_system_lib.Notification;
import com.codecool.virtual_pet.notification_system_lib.NotificationHandler;
import com.codecool.virtual_pet.view.PetSetupView;

public class PetSetupController implements NotificationHandler {

    private PetSetupView petSetupView;

    public PetSetupController(PetSetupView petSetupView) {
        this.petSetupView = petSetupView;
    }

    public PetSetupView getView() {
        return petSetupView;
    }

    @Override
    public boolean handleNotification(Notification notification) {
        String petName = notification.getNotificationData().toString();
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
