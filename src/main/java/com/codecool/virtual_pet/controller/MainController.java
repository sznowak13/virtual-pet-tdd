package com.codecool.virtual_pet.controller;

import com.codecool.virtual_pet.notification_system_lib.Notification;
import com.codecool.virtual_pet.notification_system_lib.NotificationDispatcher;
import com.codecool.virtual_pet.notification_system_lib.NotificationHandler;
import com.codecool.virtual_pet.model.PetModel;
import com.codecool.virtual_pet.view.*;

import java.util.HashMap;
import java.util.Map;

public class MainController implements NotificationDispatcher {

    private SceneRouter sceneRouter;
    private Map<ControllerName, NotificationHandler> controllers = new HashMap<>();

    public MainController(SceneRouter sceneRouter) {
        this.sceneRouter = sceneRouter;
    }

    public void init() {
        PetSetupController petSetupController = new PetSetupController(new PetSetupView());
        petSetupController.getView().addEventDispatcher(this);
        sceneRouter.addSetupScene(petSetupController.getView());
        sceneRouter.changeSceneTo(SceneName.SETUP);
        controllers.put(ControllerName.SETUP_CONTROLLER, petSetupController);
    }

    @Override
    public void dispatch(Notification notification) {
        switch (notification.getNotificationCode()) {
            case CREATE_PET:
                handlePetCreation(notification);
                break;
            default:
                System.out.println(notification.getNotificationCode());
        }
    }

    private void handlePetCreation(Notification notification) {
        boolean created = controllers.get(ControllerName.SETUP_CONTROLLER).handleNotification(notification);
        if (created) {
            startGamePlay(notification.getNotificationData().toString());
        }
    }

    private void startGamePlay(String petName) {
        PetController petController = new PetController(new PetModel(petName));
        petController.createPetOverview();
        petController.getPetView().addActionEventDispatcher(this);
        sceneRouter.addPetScene(petController.getPetView());
        sceneRouter.changeSceneTo(SceneName.PET_MAIN_VIEW);
        controllers.put(ControllerName.PET_CONTROLLER, petController);
    }
}
