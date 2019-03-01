package com.codecool.virtual_pet.view;

import com.codecool.virtual_pet.notification_system_lib.Notification;
import com.codecool.virtual_pet.notification_system_lib.NotificationBroadcaster;
import com.codecool.virtual_pet.notification_system_lib.NotificationCode;
import com.codecool.virtual_pet.notification_system_lib.NotificationDispatcher;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PetSetupView extends VBox {

    private TextField petNameField = new TextField();
    private Button createButton = new Button("Hatch!");
    private Text errorMsg = new Text();
    private NotificationBroadcaster eb = new NotificationBroadcaster();

    public PetSetupView() {
        super(15);
        setAlignment(Pos.CENTER);
        petNameField.setPromptText("Enter name here...");
        petNameField.setAlignment(Pos.CENTER);
        petNameField.setMaxWidth(200);
        createButton.setOnAction(event -> eb.broadcast(
                new Notification(NotificationCode.CREATE_PET, petNameField.getCharacters().toString()))
        );
        getChildren().addAll(
                new Label("Your pet name:"),
                petNameField,
                createButton,
                errorMsg
        );
    }

    public void addEventDispatcher(NotificationDispatcher notificationDispatcher) {
        eb.addSubscriber(notificationDispatcher);
    }

    public void displayError(String error) {
        errorMsg.setText(error);
    }
}
