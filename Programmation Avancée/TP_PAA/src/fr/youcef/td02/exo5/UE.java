package fr.youcef.td02.exo5;

public class UE {
    private String nom;
    // private int coefficient;

    public UE(String nom/*, int coefficient*/) {
        this.nom = nom;
        //this.coefficient = coefficient;
    }

    public String getNom() {
        return this.nom;
    }
    /*
    public int getCoefficient() {
        return this.coefficient;
    }
    */
    public String toString() {
        return this.nom + " "/* + this.coefficient*/;
    }
}
