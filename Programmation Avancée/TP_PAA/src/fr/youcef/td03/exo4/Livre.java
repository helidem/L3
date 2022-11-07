package fr.youcef.td03.exo4;

public class Livre extends Produit{
    String titre;
    String auteur;
    String ISBN;

    public Livre(double prixHT, String titre, String auteur, String ISBN) {
        super(prixHT, TVA.reduit);
        this.titre = titre;
        this.auteur = auteur;
        this.ISBN = ISBN;
    }
}
