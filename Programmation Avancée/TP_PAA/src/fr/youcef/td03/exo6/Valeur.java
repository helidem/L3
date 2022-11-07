package fr.youcef.td03.exo6;

public class Valeur extends Operateur{
    private int valeur;

    public Valeur() {
        super(0, null);
    }


    @Override
    public double evaluer() {
        return valeur;
    }
}
