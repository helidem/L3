package fr.youcef.td6.exo3;

import fr.youcef.td6.exo4.LabelLien;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class PanelCouleurBouton extends BorderPane {

    public PanelCouleurBouton() {
        Button btnRouge = new Button("Couleur Rouge");
        btnRouge.setTextFill(Color.RED);

        Button btnVert = new Button("Couleur Verte");
        btnVert.setTextFill(Color.GREEN);

        Label lblCouleur = new LabelLien("Je change de couleur");

        this.setTop(lblCouleur);
        this.setCenter(btnRouge);
        this.setBottom(btnVert);

        btnVert.setOnAction(event -> lblCouleur.setTextFill(Color.GREEN));
        btnRouge.setOnAction(event -> lblCouleur.setTextFill(Color.RED));
    }
}
