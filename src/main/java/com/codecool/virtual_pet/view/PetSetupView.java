package com.codecool.virtual_pet.view;

import com.codecool.virtual_pet.event_system_lib.Event;
import com.codecool.virtual_pet.event_system_lib.EventBroadcaster;
import com.codecool.virtual_pet.event_system_lib.EventCode;
import com.codecool.virtual_pet.event_system_lib.EventDispatcher;
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
    private EventBroadcaster eb = new EventBroadcaster();

    public PetSetupView() {
        super(15);
        setAlignment(Pos.CENTER);
        petNameField.setPromptText("Enter name here...");
        petNameField.setAlignment(Pos.CENTER);
        petNameField.setMaxWidth(200);
        createButton.setOnAction(event -> eb.broadcast(new Event(EventCode.CREATE_PET, petNameField.getCharacters())));
        getChildren().addAll(
                new Label("Your pet name:"),
                petNameField,
                createButton,
                errorMsg
        );
    }

    public void addEventDispatcher(EventDispatcher eventDispatcher) {
        eb.addSubscriber(eventDispatcher);
    }

    public void displayError(String error) {
        errorMsg.setText(error);
    }
}
