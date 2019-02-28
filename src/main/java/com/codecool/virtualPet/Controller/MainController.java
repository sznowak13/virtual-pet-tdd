package com.codecool.virtualPet.Controller;

import com.codecool.virtualPet.View.PetSetupView;
import com.codecool.virtualPet.View.SceneRouter;

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
