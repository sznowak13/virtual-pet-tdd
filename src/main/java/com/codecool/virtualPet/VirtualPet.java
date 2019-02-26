package com.codecool.virtualPet;

import com.codecool.virtualPet.Controller.PetController;
import com.codecool.virtualPet.View.DisplayConfig;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VirtualPet extends Application {

    public void start(Stage primaryStage) throws Exception {
        PetController petController = new PetController();
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(petController.getPetView());
        Scene scene = new Scene(borderPane, DisplayConfig.DISPLAY_WIDTH, DisplayConfig.DISPLAY_HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Your amazing PetModel");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
