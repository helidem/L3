package fr.youcef.td03.exo1;

import java.util.ArrayList;
import java.util.HashMap;

import static fr.youcef.td02.UtilTD2.*;

public class DicoT9 {
    private HashMap<String, ArrayList<String>> dico;

    public DicoT9() {
        dico = new HashMap<>();
    }

    public void enregistrer(String mot) {
        if (dico.containsKey(word2T9(mot))) {
            dico.get(word2T9(mot)).add(mot);
        } else {
            ArrayList<String> tmp = new ArrayList<>();
            tmp.add(mot);
            dico.put(word2T9(mot), tmp);
        }
    }

    public ArrayList<String> recuperer(String code) {
        // TODO
        return (dico.get(code) == null) ? new ArrayList() : dico.get(code);
    }

}
