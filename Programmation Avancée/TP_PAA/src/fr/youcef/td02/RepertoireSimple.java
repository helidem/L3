package fr.youcef.td02;

import java.util.ArrayList;

public class RepertoireSimple {

    private ArrayList<Personne> repertoireSimple;

    public RepertoireSimple() {
        repertoireSimple = new ArrayList<>();
    }

    public void addPersonne(String nom, String prenom, String num) {
        this.repertoireSimple.add(new Personne(nom, prenom, num));
    }

    public String chercheNumero(String nom, String prenom) {
        for (Personne p : repertoireSimple) {
            if (p.getNom().equals(nom) && p.getPrenom().equals(prenom)) {
                return p.getNumero();
            }
        }
        return "L'identité " + nom + " " + prenom + " est inconnue.";
    }
}
