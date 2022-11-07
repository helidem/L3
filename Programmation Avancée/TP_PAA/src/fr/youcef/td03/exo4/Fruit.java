package fr.youcef.td03.exo4;

public class Fruit extends Produit{
    String nom;
    String origine;

    public Fruit(double prixHT, String nom, String origine) {
        super(prixHT, TVA.reduit);
        this.nom = nom;
        this.origine = origine;
    }
}
