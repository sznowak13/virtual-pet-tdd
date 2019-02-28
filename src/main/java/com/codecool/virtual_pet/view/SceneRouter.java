package com.codecool.virtual_pet.view;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class SceneRouter {

    private Stage window;
    private Map<SceneName, Scene> sceneMap = new HashMap<>();

    public SceneRouter(Stage primaryStage) {
        window = primaryStage;
        window.show();
    }

    public void addScene(SceneName sceneName, Scene scene) {
        sceneMap.put(sceneName, scene);
    }

    public void changeSceneTo(SceneName sceneName) throws NonExistingSceneException {
        if (sceneMap.containsKey(sceneName)) {
            window.setScene(sceneMap.get(sceneName));
        } else {
            throw new NonExistingSceneException("Cannot find a scene to go to: " + sceneName);
        }
    }

    public void addSetupScene(PetSetupView view) {
        addScene(SceneName.SETUP, new Scene(view, DisplayConfig.SETUP_WIDTH, DisplayConfig.SETUP_HEIGHT));
    }

    public void addPetScene(PetOverview petView) {
        addScene(SceneName.PET_MAIN_VIEW, new Scene(petView, DisplayConfig.DISPLAY_WIDTH, DisplayConfig.DISPLAY_HEIGHT));
    }
}
