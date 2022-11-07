package fr.youcef.td03.exo6;

import java.util.ArrayList;

public class Soustraction extends Operateur {

    public Soustraction(int arite, ArrayList<Operateur> fils) {
        super(arite, fils);
    }

    @Override
    public double evaluer() {
        return getFils().get(0).evaluer() - getFils().get(1).evaluer();
    }
}
