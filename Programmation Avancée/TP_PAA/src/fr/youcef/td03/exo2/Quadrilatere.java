package fr.youcef.td03.exo2;

import fr.youcef.td02.Point;
import fr.youcef.td03.exo2.Figure;

public abstract class Quadrilatere extends Figure {

    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;

    public Quadrilatere(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    public double perimetre() {
        return p1.distance(p2) + p2.distance(p3) + p3.distance(p4) + p4.distance(p1);
    }

    public abstract double surface(); // abstrait car tout les quadrilatères n'ont pas la même formule de surface

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    public Point getP4() {
        return p4;
    }
}
