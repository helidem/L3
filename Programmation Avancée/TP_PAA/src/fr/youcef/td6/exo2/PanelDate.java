package fr.youcef.td6.exo2;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class PanelDate extends BorderPane {
    // cette classe permet grace à un bouton d'afficher la date du jour
    // et de l'actualiser en cliquant sur le bouton

    public PanelDate(){
        Label lblDate = new Label("Date du jour : " + java.time.LocalDateTime.now());
        Button btnDate = new Button("Actualiser");

        // lambda expression
        btnDate.setOnAction(event -> lblDate.setText("Date du jour : " + java.time.LocalDateTime.now()));

        this.setCenter(lblDate);
        this.setBottom(btnDate);
    }
}
