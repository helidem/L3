package fr.youcef.td03.exo6;

import java.util.ArrayList;

public abstract class  Operateur {
    private int arite;
    private ArrayList<Operateur> fils;

    public Operateur(int arite, ArrayList<Operateur> fils) {
        this.arite = arite;
        this.fils = fils;
    }
    public abstract double evaluer();

    public int getArite() {
        return arite;
    }

    public ArrayList<Operateur> getFils() {
        return fils;
    }

}
