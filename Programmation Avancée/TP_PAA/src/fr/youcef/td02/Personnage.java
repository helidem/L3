package fr.youcef.td02;

public class Personnage {
    String nom;
    private int pv;

    private int pvMax;
    private Arme arme1;
    private Arme arme2;

    public Personnage(String nom, int pv, Arme arme1, Arme arme2) {
        this.nom = nom;
        this.pv = pv;
        this.pvMax = pv;
        this.arme1 = arme1;
        this.arme2 = arme2;
    }

    public String getNom() {
        return nom;
    }

    public int getPv() {
        return pv;
    }

    public Arme getArme1() {
        return arme1;
    }

    public Arme getArme2() {
        return arme2;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public boolean isDead(){
        return pv <= 0;
    }

    public int getPvMax() {
        return pvMax;
    }

    public String toString(){
        return "Le personnage " + nom + " a " + pv + " points de vie. Il peut attaquer " + getArme1().getEndurance() + " fois avec " + getArme1().getNom() + " et " + getArme2().getEndurance() + " fois avec " + getArme2().getNom();
    }
}
