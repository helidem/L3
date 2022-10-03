package fr.youcef.td02;

public class Vecteur {
    private Point A;
    private Point B;

    public Vecteur(Point a, Point b) {
        A = a;
        B = b;
    }

    public Point getA() {
        return A;
    }

    public Point getB() {
        return B;
    }

    /**
     * Méthode qui vérifie si deux vecteurs sont égaux
     * @param v le vecteur avec lequel on veut vérifier l'égalité
     * @return true si les deux vecteurs sont égaux, false sinon
     */
    public boolean equals(Vecteur v){
        return ((this.B.getAbscisse() - this.A.getAbscisse()) == (v.getB().getAbscisse() - v.getA().getAbscisse()))
                && ((this.B.getOrdonnée() - this.A.getOrdonnée()) == (v.getB().getOrdonnée() - v.getA().getOrdonnée()));
    }
}
