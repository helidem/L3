package fr.youcef.td02;

public class Disque {
    private Point centre;
    private double rayon;

    public Disque(Point centre, double rayon) {
        this.centre = centre;
        this.rayon = rayon;
    }

    /**
     * Méthode qui permet de vérifier si un disque est en intersection avec un autre disque
     * @param d le disque avec lequel on veut verifier l'intersection
     * @return true si les deux disques sont en intersection, false sinon
     */
    public boolean enIntersection(Disque d){
        return centre.distance(d.getCentre()) <= rayon + d.getRayon();
    }

    public Disque translation(Vecteur vecteur){
        return new Disque(this.centre.translation(vecteur), this.rayon);
    }

    public Point getCentre() {
        return centre;
    }

    public double getRayon() {
        return rayon;
    }
}
