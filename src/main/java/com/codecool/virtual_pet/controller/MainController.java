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
        PetSetupController petSetupController = createPetSetupController();
        initSetupScene(petSetupController.getView());
    }

    private void initSetupScene(PetSetupView petSetupView) {
        sceneRouter.addSetupScene(petSetupView);
        sceneRouter.changeSceneTo(SceneName.SETUP);
    }

    private PetSetupController createPetSetupController() {
        PetSetupController petSetupController = new PetSetupController(new PetSetupView());
        petSetupController.getView().addNotificationDispatcher(this);
        controllers.put(ControllerName.SETUP_CONTROLLER, petSetupController);

        return petSetupController;
    }

    @Override
    public void dispatch(Notification notification) {
        switch (notification.getNotificationCode()) {
            case CREATE_PET:
                handlePetCreation(notification);
                break;
            case SLEEP:
            case PLAY_WITH_PET:
            case FEED_PET:
            case OPEN_FOOD_INVENTORY:
                controllers.get(ControllerName.PET_CONTROLLER).handleNotification(notification);
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
        PetController petController = createPetController(petName);
        initPetMainView(petController.getPetView());
        petController.startPet();
    }

    private PetController createPetController(String petName) {
        PetController petController = new PetController(new PetModel(petName));
        petController.createPetOverview();
        petController.getPetView().addActionNotificationDispatcher(this);
        controllers.put(ControllerName.PET_CONTROLLER, petController);

        return petController;
    }

    private void initPetMainView(PetOverview petOverview) {
        sceneRouter.addPetScene(petOverview);
        sceneRouter.changeSceneTo(SceneName.PET_MAIN_VIEW);

    }

    public void stop() {
        PetController pc = (PetController) controllers.get(ControllerName.PET_CONTROLLER);
        pc.stop();
    }
}
