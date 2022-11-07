package fr.youcef.td03.exo5;

public class Divertissement extends Programme{
    String presentateur;
    String nomEmission;

    public Divertissement(int heureDebut, String presentateur, String nomEmission) {
        super(heureDebut, heureDebut+2);
        this.presentateur = presentateur;
        this.nomEmission = nomEmission;
    }
}
