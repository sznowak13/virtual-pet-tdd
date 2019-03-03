package com.codecool.virtual_pet.controller;

import com.codecool.virtual_pet.model.PetFood;
import com.codecool.virtual_pet.notification_system_lib.Notification;
import com.codecool.virtual_pet.notification_system_lib.NotificationHandler;
import com.codecool.virtual_pet.model.PetModel;
import com.codecool.virtual_pet.view.PetOverview;

public class PetController implements NotificationHandler {

    private PetModel petModel;
    private PetOverview petView;

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
        switch (notification.getNotificationCode()) {
            case FEED_PET:
                Object data = notification.getNotificationData();
                if (data instanceof PetFood) {
                    petModel.feed((PetFood) data);
                } else {
                    throw new IllegalArgumentException("No food to feed!");
                }
                break;
            case SLEEP:
                //TODO pet sleeps
                break;
            case PLAY_WITH_PET:
                //TODO playing with pet
                break;
            default:
                return false;
        }
        return true;
    }

    public void createPetOverview() {
        setPetView(new PetOverview(petModel));
    }

    public PetModel getPetModel() {
        return petModel;
    }
}
