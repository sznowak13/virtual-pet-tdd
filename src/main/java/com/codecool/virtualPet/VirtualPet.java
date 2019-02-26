package com.codecool.virtualPet;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VirtualPet extends Application {
    
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new BorderPane(), 800, 600);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Your amazing Pet");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
