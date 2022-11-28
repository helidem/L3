package fr.youcef.td6.exo4;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class LabelLien extends Label {
    private Color color;

    public LabelLien(String text) {
        super(text);
        this.setOnMouseEntered(event -> {
            this.color = (Color) this.getTextFill();
            this.setTextFill(Color.BLUE);
        });
        this.setOnMouseExited(event -> this.setTextFill(color));

    }
}

