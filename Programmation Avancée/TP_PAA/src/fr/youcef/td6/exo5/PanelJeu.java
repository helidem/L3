package fr.youcef.td6.exo5;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PanelJeu extends javafx.scene.layout.BorderPane {

    private Jeu jeu;

    public PanelJeu() {
        Label lblProposition = new Label("Proposition : ");
        Button btnPlus = new Button("-");
        Button btnMoins = new Button("+");
        Button btnEgal = new Button("=");

        jeu = new Jeu(0, 100);
        lblProposition.setText(Integer.toString(jeu.getProposition()));



        this.setCenter(lblProposition);
        this.setBottom(btnEgal);
        this.setLeft(btnMoins);
        this.setRight(btnPlus);

        btnPlus.setOnAction(new PlusHandler(lblProposition, jeu));
        btnMoins.setOnAction(new MoinsHandler(lblProposition, jeu));
        btnEgal.setOnAction(new EgalHandler(lblProposition, jeu));
    }
}
