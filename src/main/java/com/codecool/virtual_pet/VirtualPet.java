package com.codecool.virtual_pet;

import com.codecool.virtual_pet.controller.MainController;
import com.codecool.virtual_pet.view.SceneRouter;
import javafx.application.Application;
import javafx.stage.Stage;

public class VirtualPet extends Application {

    private MainController mainController;

    public void start(Stage primaryStage) throws Exception {
        mainController = new MainController(new SceneRouter(primaryStage));
        mainController.init();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() {
        System.out.println("Exiting...");
        mainController.stop();
        System.out.println("Exited");
    }
}
