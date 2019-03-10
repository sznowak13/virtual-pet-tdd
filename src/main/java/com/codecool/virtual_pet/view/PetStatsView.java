package com.codecool.virtual_pet.view;

import com.codecool.virtual_pet.model.PetStats;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

public class PetStatsView extends VBox {

    private ProgressBar hungerBar = new ProgressBar();
    private ProgressBar tirednessBar = new ProgressBar();
    private ProgressBar happinessBar = new ProgressBar();

    public PetStatsView(PetStats petStats) {
        hungerBar.setProgress(petStats.getHunger() / 100);
        tirednessBar.setProgress(petStats.getTiredness() / 100);
        happinessBar.setProgress(petStats.getHappiness() / 100);
        getChildren().addAll(
                new Label("Hunger:"), hungerBar,
                new Label("Tiredness:"), tirednessBar,
                new Label("Happiness:"), happinessBar
        );
        setAlignment(Pos.CENTER);
    }

    public void updateHunger(double hunger) {
        hungerBar.setProgress(hunger / 100);
    }

    public void updateTiredness(double tiredness) {
        tirednessBar.setProgress(tiredness / 100);
    }

    public void updateHappiness(double happiness) {
        happinessBar.setProgress(happiness / 100);
    }
}
