package fr.youcef.td6.exo5;

public class Jeu {
    // le nombre minimum à trouver
    private int minInitial;
    // le nombre maximum à trouver
    private int maxInitial;

    // au cours d'un jeu, le minimum deduit des reponses précédentes
    private int min;
    // au cours d'un jeu, le maximum deduit des reponses précédentes
    private int max;
    private int nbPropositions;
    private boolean gagne = false;

    public Jeu(int minInitial, int maxInitial) {
        this.minInitial = minInitial;
        this.maxInitial = maxInitial;
        resert();
    }

    public void resert() {
        min = minInitial;
        max = maxInitial;
        nbPropositions = 0;
        gagne = false;
    }

    public boolean isJeuSansSolution() {
        return min > max;
    }

    public boolean isGagne() {
        return gagne;
    }

    public int getProposition() {
        return (min + max) / 2;
    }

    public int getNbPropositions() {
        return nbPropositions;
    }

    public void noterPropositionTropPetite(){
        min = getProposition() + 1;
        nbPropositions++;
    }

    public void noterPropositionTropGrande(){
        max = getProposition() - 1;
        nbPropositions++;
    }

    public void noterPropositionOK(){
        this.nbPropositions++;
        this.min = this.max = this.getProposition();
        this.gagne = true;
    }

}
