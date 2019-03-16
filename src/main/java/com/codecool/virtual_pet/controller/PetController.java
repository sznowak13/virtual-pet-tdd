package com.codecool.virtual_pet.controller;

import com.codecool.virtual_pet.model.pet_food.FoodName;
import com.codecool.virtual_pet.model.pet_food.PetFood;
import com.codecool.virtual_pet.model.pet_food.PetFoodFactory;
import com.codecool.virtual_pet.notification_system_lib.Notification;
import com.codecool.virtual_pet.notification_system_lib.NotificationHandler;
import com.codecool.virtual_pet.model.PetModel;
import com.codecool.virtual_pet.view.PetOverview;

public class PetController implements NotificationHandler {

    private PetModel petModel;
    private PetOverview petView;
    private Thread petLifeCycleThread;
    private Thread petThoughtsUpdater;

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
            case OPEN_FOOD_INVENTORY:
                petView.openFoodInventory(new PetFood[] {
                        PetFoodFactory.createFood(FoodName.MEAT),
                        PetFoodFactory.createFood(FoodName.ENERGY_TABS),
                        PetFoodFactory.createFood(FoodName.MILK),
                        PetFoodFactory.createFood(FoodName.FAT)
                });
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

    public void startPet() {
        petModel.setRandomFoodTaste();
        petModel.start();
        petLifeCycleThread = new Thread(new PetLifeCycleUpdater(), "pet-lifecycle");
        petThoughtsUpdater = new Thread(new PetThoughtsUpdater(), "pet-thoughts");
        petThoughtsUpdater.start();
        petLifeCycleThread.start();
    }

    public void createPetOverview() {
        setPetView(new PetOverview(petModel));
    }

    public PetModel getPetModel() {
        return petModel;
    }

    public void stop() {
        try {
            petModel.setActive(false);
            petModel.stop();
            petLifeCycleThread.join();
            petThoughtsUpdater.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class PetLifeCycleUpdater implements Runnable {

        @Override
        public void run() {
            while(petModel.isActive()) {
                petView.updateStats(petModel.getStats());
            }
        }
    }

    private class PetThoughtsUpdater implements Runnable {

        @Override
        public void run() {
            while (petModel.isActive()) {
                try {
                    Thread.sleep(2000);
                    petView.updateThoughts(petModel);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
