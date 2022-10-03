package fr.youcef.td02;

public class Point {
    private double abscisse;
    private double ordonnée;

    public Point(double abscisse, double ordonnée) {
        this.abscisse = abscisse;
        this.ordonnée = ordonnée;
    }

    /**
     * Méthode qui calcule la distance entre deux points
     * @param p le point dont on veut calculer la distance
     * @return la distance entre le point courant et le point p
     */
    public double distance(Point p){
        return Math.sqrt(Math.pow(p.abscisse-this.abscisse,2)+Math.pow(p.ordonnée-this.ordonnée,2));
    }

    /**
     * Méthode qui permet de verifier si un point est dans un disque
     * @param d le disque dans lequel on veut verifier si le point est
     * @return true si le point est dans le disque, false sinon
     */
    public boolean estDansDisque(Disque d){
        return distance(d.getCentre()) >=d.getRayon();
    }

    /**
     * Méthode qui permet de faire une translation d'un point par rapport à un vecteur
     * @param v le vecteur de translation
     * @return le point après translation
     */
    public Point translation(Vecteur v){
        return new Point(this.abscisse+v.getB().getAbscisse()-v.getA().getAbscisse(),this.ordonnée+v.getB().getOrdonnée()-v.getA().getOrdonnée());
    }

    public double getAbscisse() {
        return abscisse;
    }

    public double getOrdonnée() {
        return ordonnée;
    }
}
