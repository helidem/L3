package fr.youcef.td6.exo1;

public class Compteur {
    private int valeur;

    public Compteur() {
        valeur = 0;
    }

    public void incrementer() {
        valeur++;
    }

    public void incrementer(int n) {
        valeur += n;
    }

    public int getValeur() {
        return valeur;
    }
}
