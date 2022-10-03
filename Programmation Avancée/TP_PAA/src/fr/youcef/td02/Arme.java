package fr.youcef.td02;

public class Arme {
    private int degats;
    private String nom;
    private int endurance;

    public Arme(String nom, int degats, int endurance) {
        this.nom = nom;
        this.degats = degats;
        this.endurance = endurance;
    }

    public int getDegats() {
        return degats;
    }

    public String getNom() {
        return nom;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int i) {
        this.endurance = i;
    }
}
