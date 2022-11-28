package fr.youcef.td03.exo3;

import fr.youcef.td02.Personne;
import fr.youcef.td4.exo4.RepertoireInvalide;

public class RepertoireAmeliore extends fr.youcef.td02.RepertoireSimple {
    private Personne proprietaire;


    public RepertoireAmeliore(Personne personne) {
        super();
        this.proprietaire = personne;
    }

    public String cherchePersonne(String s) throws RepertoireInvalide {
        for (Personne p : getRepertoireSimple()) {
            if (p.getNumero().equals(s)) {
                return p.getNom() + " " + p.getPrenom();
            }
        }
        throw new RepertoireInvalide("Le numéro " + s + " est inconnu.");
    }

    public String toString() {
        String s = "Propriétaire : " + proprietaire.getNom() + " " + proprietaire.getPrenom() + " " + proprietaire.getNumero() + "\n";
        for (Personne p : getRepertoireSimple()) {
            s += p.getNom() + " " + p.getPrenom() + " " + p.getNumero() + "\n";
        }
        return s;
    }

    public Personne getProprietaire() {
        return proprietaire;
    }
}
