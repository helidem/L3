package fr.youcef.td03.exo4;

public abstract class Produit {
    private double prixHT;
    private TVA tva;

    public Produit(double prixHT, TVA tva) {
        this.prixHT = prixHT;
        this.tva = tva;
    }

    public double getPrixHT() {
        return prixHT;
    }

    public double getTauxTva(){
        return tva.getTaux();
    }

    public TVA getTva() {
        return tva;
    }

    public double getPrixTTC() {
        return prixHT * (1 + tva.getTaux());
    }

}
