package fr.youcef.td6.exo1;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public class CompteurPane extends FlowPane {
    Label lab;
    Button button;
    Compteur compteur;

    public CompteurPane(){
        lab = new Label("0");
        button = new Button("Clic");
        compteur = new Compteur();

        button.setOnAction(new CompteurHandler(lab, compteur));
        this.getChildren().addAll(button, lab);

    }
}
