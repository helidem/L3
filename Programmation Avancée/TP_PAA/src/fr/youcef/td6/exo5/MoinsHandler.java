package fr.youcef.td6.exo5;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class MoinsHandler implements EventHandler<ActionEvent> {
    private Label lblProposition;
    private Jeu jeu;
    public MoinsHandler(Label lblProposition, Jeu jeu) {
        this.lblProposition = lblProposition;
        this.jeu = jeu;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        jeu.noterPropositionTropPetite();
        lblProposition.setText(Integer.toString(jeu.getProposition()));
    }
}
