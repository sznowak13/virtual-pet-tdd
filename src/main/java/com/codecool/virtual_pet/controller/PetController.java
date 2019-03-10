package com.codecool.virtual_pet.controller;

import com.codecool.virtual_pet.model.PetFood;
import com.codecool.virtual_pet.notification_system_lib.Notification;
import com.codecool.virtual_pet.notification_system_lib.NotificationHandler;
import com.codecool.virtual_pet.model.PetModel;
import com.codecool.virtual_pet.view.PetOverview;

public class PetController implements NotificationHandler {

    private PetModel petModel;
    private PetOverview petView;
    private Thread petLifeCycleThread;

    public PetController(PetModel petModel) {
        this.petModel = petModel;
        petModel.start();
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
                    handleFeeding((PetFood) data);
                } else {
                    throw new IllegalArgumentException("No food to feed!");
                }
                break;
            case SLEEP:
                petModel.setSleeping(true);
                break;
            case PLAY_WITH_PET:
                //TODO playing with pet
                break;
            default:
                return false;
        }
        return true;
    }

    private void handleFeeding(PetFood food) {
        petModel.feed(food);
        if (petView != null) {
            petView.updateStats(petModel.getStats());
        }
    }

    public void createPetOverview() {
        setPetView(new PetOverview(petModel));
        petLifeCycleThread = new Thread(() -> {
            while(petModel.isActive()) {
                petView.updateStats(petModel.getStats());
            }
        }, "pet-lifecycle");
        petLifeCycleThread.start();
    }

    public PetModel getPetModel() {
        return petModel;
    }

    public void stop() {
        try {
            petModel.setActive(false);
            petModel.stop();
            petLifeCycleThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
