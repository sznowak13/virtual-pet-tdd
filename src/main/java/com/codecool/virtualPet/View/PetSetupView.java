package com.codecool.virtualPet.View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.beans.PropertyChangeSupport;

public class PetSetupView extends VBox {

    private TextField petNameField = new TextField();
    private Button createButton = new Button("Hatch!");
    private PropertyChangeSupport support;

    public PetSetupView() {
        super(15);
        support = new PropertyChangeSupport(this);
        setAlignment(Pos.CENTER);
        petNameField.setPromptText("Enter name here...");
        petNameField.setAlignment(Pos.CENTER);
        petNameField.setMaxWidth(200);
        getChildren().addAll(
                new Label("Your pet name:"),
                petNameField,
                createButton
        );
    }
}
