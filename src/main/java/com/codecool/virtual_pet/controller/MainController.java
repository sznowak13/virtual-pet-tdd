package com.codecool.virtual_pet.controller;

import com.codecool.virtual_pet.event_system_lib.Event;
import com.codecool.virtual_pet.event_system_lib.EventDispatcher;
import com.codecool.virtual_pet.event_system_lib.EventHandler;
import com.codecool.virtual_pet.model.PetModel;
import com.codecool.virtual_pet.view.*;

import java.util.HashMap;
import java.util.Map;

public class MainController implements EventDispatcher {

    private SceneRouter sceneRouter;
    private Map<ControllerName, EventHandler> controllers = new HashMap<>();

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
    public void dispatch(Event event) {
        switch (event.getEventCode()) {
            case CREATE_PET:
                handlePetCreation(event);
                break;
            default:
                System.out.println(event.getEventCode());
        }
    }

    private void handlePetCreation(Event event) {
        boolean created = controllers.get(ControllerName.SETUP_CONTROLLER).handleEvent(event);
        if (created) {
            startGamePlay(event.getEventData().toString());
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
