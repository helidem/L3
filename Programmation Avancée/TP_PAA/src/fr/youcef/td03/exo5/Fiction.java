package fr.youcef.td03.exo5;

public class Fiction extends Programme{
    String titre;
    String nomRealisateur;
    boolean rediffusion;

    public Fiction(int heureDebut, int heureFin, String titre, String nomRealisateur, boolean rediffusion) {
        super(heureDebut, heureFin);
        this.titre = titre;
        this.nomRealisateur = nomRealisateur;
        this.rediffusion = rediffusion;
    }
}
