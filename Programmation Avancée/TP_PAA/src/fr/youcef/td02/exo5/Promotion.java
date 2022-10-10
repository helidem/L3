package fr.youcef.td02.exo5;

import java.util.ArrayList;

public class Promotion {
    private static ArrayList<Etudiant> etudiants;
    private ArrayList<UE> ues;

    public Promotion() {
        etudiants = new ArrayList<Etudiant>();
        ues = new ArrayList<UE>();
        // les ues sont : POO, MATHS, ALGO, RESEAUX, ANGLAIS
        ues.add(new UE("POO"));
        ues.add(new UE("MATHS"));
        ues.add(new UE("ALGO"));
        ues.add(new UE("RESEAUX"));
        ues.add(new UE("ANGLAIS"));
    }

    public void ajouterEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
    }

    public void ajouterUE(UE ue) {
        ues.add(ue);
    }

    public void ajouterNoteCC(Etudiant etudiant, UE ue, double note) {
        etudiant.ajouterNoteCC(ue, note);
    }

    public void ajouterNoteEX(Etudiant etudiant, UE ue, double note) {
        etudiant.ajouterNoteEX(ue, note);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Etudiant etudiant : etudiants) {
            sb.append(etudiant.toString()).append("\n");
        }
        return sb.toString();
    }

    public double moyenneGenerale() {
        double somme = 0;
        for (Etudiant etudiant : etudiants) {
            somme += etudiant.moyenne();
        }
        return somme / etudiants.size();
    }

    public double moyenneUE(UE ue) {
        double somme = 0;
        for (Etudiant etudiant : etudiants) {
            somme += etudiant.noteFinale(ue);
        }
        return somme / etudiants.size();
    }



    public Etudiant meilleurEtudiant() {
        Etudiant meilleurEtudiant = etudiants.get(0);
        for (Etudiant etudiant : etudiants) {
            if (etudiant.moyenne() > meilleurEtudiant.moyenne()) {
                meilleurEtudiant = etudiant;
            }
        }
        return meilleurEtudiant;
    }

    public Etudiant meilleurEtudiantUE(UE ue){
        Etudiant meilleurEtudiant = etudiants.get(0);
        for (Etudiant etudiant : etudiants) {
            if (etudiant.noteFinale(ue) > meilleurEtudiant.noteFinale(ue)) {
                meilleurEtudiant = etudiant;
            }
        }
        return meilleurEtudiant;
    }


    public Etudiant getEtudiant(String nom, String prenom) {
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getNom().equals(nom) && etudiant.getPrenom().equals(prenom)) {
                return etudiant;
            }
        }
        return null;
    }

    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }

    public ArrayList<UE> getUes() {
        return ues;
    }

    public UE getUE(String nom) {
        for (UE ue : ues) {
            if (ue.getNom().equals(nom)) {
                return ue;
            }
        }
        return null;
    }


    public void afficherEtudiants() {
        for (Etudiant etudiant : etudiants) {
            System.out.println(etudiant.toString());
        }
    }

}
