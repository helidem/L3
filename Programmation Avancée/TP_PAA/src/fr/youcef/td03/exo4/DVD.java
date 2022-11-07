package fr.youcef.td03.exo4;

public class DVD extends Produit{

    String titre;
    String realisateur;

    public DVD(double prixHT,String titre, String realisateur) {
        super(prixHT, TVA.normal);
        this.titre = titre;
        this.realisateur = realisateur;
    }
}
