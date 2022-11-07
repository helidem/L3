package fr.youcef.td03.exo6;

import java.util.ArrayList;

public class AdditionNAire extends Operateur{

    public AdditionNAire(int arite, ArrayList<Operateur> fils) {
        super(arite, fils);
    }

    @Override
    public double evaluer() {
        double res = 0;
        ArrayList<Operateur> list = getFils();
        for (Operateur o: list) {
            res += o.evaluer();
        }
        return res;
    }

}
