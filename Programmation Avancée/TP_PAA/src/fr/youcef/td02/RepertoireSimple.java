package fr.youcef.td02;

import fr.youcef.td4.exo4.RepertoireInvalide;

import java.util.ArrayList;

public class RepertoireSimple {

    private ArrayList<Personne> repertoireSimple;

    public RepertoireSimple() {
        repertoireSimple = new ArrayList<>();
    }

    public void addPersonne(String nom, String prenom, String num) throws RepertoireInvalide {
        if (this.repertoireSimple == null) {
            throw new RepertoireInvalide("Le répertoire est vide.");
        }
        this.repertoireSimple.add(new Personne(nom, prenom, num));
    }

    public String chercheNumero(String nom, String prenom) throws RepertoireInvalide {
        for (Personne p : repertoireSimple) {
            if (p.getNom().equals(nom) && p.getPrenom().equals(prenom)) {
                return p.getNumero();
            }
        }
        throw new RepertoireInvalide("L'identité " + nom + " " + prenom + " est inconnue.");
    }

    public ArrayList<Personne> getRepertoireSimple() {
        return repertoireSimple;
    }
}
