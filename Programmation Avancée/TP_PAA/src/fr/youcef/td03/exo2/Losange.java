package fr.youcef.td03.exo2;

import fr.youcef.td02.Point;
import fr.youcef.td02.Vecteur;

public class Losange extends Quadrilatere{

    private double cote;

    public Losange(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }

    public double surface() {
        double d1 = getP1().distance(getP3());
        double d2 = getP2().distance(getP4());
        return (d1 * d2) / 2;
    }

    @Override
    public Figure translation(Vecteur v) {
        return new Losange(getP1().translation(v), getP2().translation(v), getP3().translation(v), getP4().translation(v));
    }
}
