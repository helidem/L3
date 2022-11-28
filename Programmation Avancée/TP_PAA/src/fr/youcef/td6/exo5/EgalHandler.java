package fr.youcef.td6.exo5;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class EgalHandler implements EventHandler<ActionEvent> {
    private Label lblProposition;
    private Jeu jeu;

    public EgalHandler(Label lblProposition, Jeu jeu) {
        this.lblProposition = lblProposition;
        this.jeu = jeu;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        jeu.noterPropositionOK();
        lblProposition.setText("Gagné");
    }
}
