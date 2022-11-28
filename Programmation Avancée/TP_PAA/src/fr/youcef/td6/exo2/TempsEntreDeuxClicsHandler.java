package fr.youcef.td6.exo2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class TempsEntreDeuxClicsHandler implements EventHandler<ActionEvent> {
    private Label lblTemps;
    private long tempsDebut;
    private long tempsFin;

    public TempsEntreDeuxClicsHandler(Label lblTemps) {
        this.lblTemps = lblTemps;
        tempsDebut = 0;
    }

    @Override
    public void handle(ActionEvent event) {
        tempsFin = System.currentTimeMillis();
        lblTemps.setText("Temps entre deux clics : " + (tempsFin - tempsDebut) + " ms");
        tempsDebut = tempsFin;
    }
}
