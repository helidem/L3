package fr.youcef.td6.exo2;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class PanelTempsEntreDeuxClics extends BorderPane {

    public PanelTempsEntreDeuxClics(){
        Label lblTemps = new Label("Temps entre deux clics : ");
        Button btnTemps = new Button("Appuie!");

        this.setCenter(lblTemps);
        this.setBottom(btnTemps);

        btnTemps.setOnAction(new TempsEntreDeuxClicsHandler(lblTemps));
    }
}
