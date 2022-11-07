package fr.youcef.td03.exo2;

import fr.youcef.td02.Point;
import fr.youcef.td02.Vecteur;

public class Disque extends Figure {
    private double rayon;
    private Point centre;
    public Disque(Point point, double rayon) {
        this.centre = point;
        this.rayon = rayon;

    }

    @Override
    public double perimetre() {
        return 2 * Math.PI * rayon;
    }

    @Override
    public double surface() {
        return Math.PI * rayon * rayon;
    }

    @Override
    public Figure translation(Vecteur v) {
        return new Disque(this.centre.translation(v), this.rayon);
    }
}
