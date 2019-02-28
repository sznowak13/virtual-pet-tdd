package com.codecool.virtualPet.View;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class SceneRouter {

    private Stage window;
    private Map<String, Scene> sceneMap = new HashMap<>();

    public SceneRouter(Stage primaryStage) {
        window = primaryStage;
        window.show();
    }

    public void addScene(String sceneName, Scene scene) {
        sceneMap.put(sceneName, scene);
    }

    public void changeSceneTo(String sceneName) throws NonExistingSceneException {
        if (sceneMap.containsKey(sceneName)) {
            window.setScene(sceneMap.get(sceneName));
        } else {
            throw new NonExistingSceneException("Cannot find a scene to go to: " + sceneName);
        }
    }

    public void addSetupScene(PetSetupView view) {
        addScene("SETUP", new Scene(view, DisplayConfig.SETUP_WIDTH, DisplayConfig.SETUP_HEIGHT));
        try {
            changeSceneTo("SETUP");
        } catch (NonExistingSceneException e) {
            e.printStackTrace();
        }
    }
}
