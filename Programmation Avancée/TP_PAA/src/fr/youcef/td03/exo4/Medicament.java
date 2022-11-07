package fr.youcef.td03.exo4;

public class Medicament extends Produit{
    String nom;
    String laboratoire;
    int quantite;

    public Medicament(double prixHT, String nom, String laboratoire, int quantite) {
        super(prixHT, TVA.particulier);
        this.nom = nom;
        this.laboratoire = laboratoire;
        this.quantite = quantite;
    }
}

