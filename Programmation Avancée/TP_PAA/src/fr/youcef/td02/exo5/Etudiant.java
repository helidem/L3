package fr.youcef.td02.exo5;

import java.util.ArrayList;
import java.util.HashMap;

public class Etudiant {
    private String nom, prenom;
    // pour chaque UE, il y a deux notes : CC et EX. On peut ajouter autant d'UE que l'on veut
    private HashMap<UE, ArrayList<Double>> notes;
    // l'arrayList contient les notes de l'étudiant pour chaque UE. L'index 0 correspond à la note de CC et l'index 1 à la note de EX


    public Etudiant(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.notes = new HashMap<UE, ArrayList<Double>>();
    }

    public void ajouterNoteCC(UE ue, double note) {
        if (this.notes.containsKey(ue)) {
            this.notes.get(ue).set(0, note);
        } else {
            ArrayList<Double> notes = new ArrayList<Double>();
            notes.add(note);
            notes.add(0.0);
            this.notes.put(ue, notes);
        }
    }

    public void ajouterNoteEX(UE ue, double note) {
        // regarde si le nom (getNom) de l'UE est déjà dans la liste des notes
        if (this.notes.containsKey(ue)) {
            // si oui, on récupère la liste des notes de l'UE et on remplace la note EX (index 1) par la nouvelle note
            this.notes.get(ue).set(1, note);
        } else {
            // si non, on crée une nouvelle liste de notes pour l'UE
            ArrayList<Double> notes = new ArrayList<Double>();
            // on ajoute la note CC (index 0) et la note EX (index 1)
            notes.add(0.0);
            notes.add(note);
            // on ajoute l'UE et la liste de notes dans la liste des notes de l'étudiant
            this.notes.put(ue, notes);
        }

    }

    public double noteFinale(UE ue) {
        return Math.max(this.notes.get(ue).get(0), this.notes.get(ue).get(1));
    }

    public double moyenne() {
        double somme = 0;
        for (UE ue : this.notes.keySet()) {
            somme += this.noteFinale(ue);
        }
        return somme / this.notes.size();
    }


    public String moyenneParUE() {
        StringBuilder sb = new StringBuilder();
        for (UE ue : this.notes.keySet()) {
            sb.append("- ")
                    .append(ue.getNom())
                    .append(" : ")
                    .append(this.noteFinale(ue))
                    .append("/20").append("\n");
        }
        return sb.toString();
    }


    public String toString() {
        return this.nom + " " + this.prenom + " moyenne par UE : \n" + moyenneParUE();
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}
