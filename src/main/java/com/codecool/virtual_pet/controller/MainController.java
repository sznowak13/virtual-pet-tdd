package com.codecool.virtual_pet.controller;

import com.codecool.virtual_pet.view.PetSetupView;
import com.codecool.virtual_pet.view.SceneRouter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainController implements PropertyChangeListener {

    private SceneRouter sceneRouter;
    private PetSetupController petSetupController;

    public MainController(SceneRouter sceneRouter) {
        this.sceneRouter = sceneRouter;
    }

    public void init() {
        petSetupController = new PetSetupController(new PetSetupView());

        sceneRouter.addSetupScene(petSetupController.getView());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
