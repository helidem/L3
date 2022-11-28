package fr.youcef.td6.exo5;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class PlusHandler implements EventHandler<ActionEvent> {
    private Label lblProposition;
    private Jeu jeu;

    public PlusHandler(Label lblProposition, Jeu jeu) {
        this.lblProposition = lblProposition;
        this.jeu = jeu;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        jeu.noterPropositionTropGrande();
        lblProposition.setText(Integer.toString(jeu.getProposition()));
    }
}
