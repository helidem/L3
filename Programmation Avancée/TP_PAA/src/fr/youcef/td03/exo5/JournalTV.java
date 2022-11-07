package fr.youcef.td03.exo5;

public class JournalTV extends Programme{
    String presentateur;
    String nom;
    Theme theme;

    public JournalTV(int heureDebut, int heureFin, String presentateur, String nom, Theme theme) {
        super(heureDebut, heureFin);
        this.presentateur = presentateur;
        this.nom = nom;
        this.theme = theme;
    }
}
