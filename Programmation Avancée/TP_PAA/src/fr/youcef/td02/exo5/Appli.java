package fr.youcef.td02.exo5;

import java.util.Scanner;

public class Appli {
    public static void main(String[] args) {
        app();
    }

    public static void app(){
        System.out.println("============= [STUDENT MANAGEMENT] =============");
        Promotion promo = new Promotion();
        promo.ajouterEtudiant(new Etudiant("MEDILEH", "Youcef"));
        promo.ajouterEtudiant(new Etudiant("MALCLES", "Jordan"));
        promo.ajouterEtudiant(new Etudiant("DUPONT", "Jean"));
        promo.ajouterEtudiant(new Etudiant("DURAND", "Pierre"));
        promo.ajouterEtudiant(new Etudiant("ZOGHLAMI", "Yacine"));
        promo.ajouterEtudiant(new Etudiant("MOROUCHE", "Lina"));

        // entrée utilisateur du choix de l'action


        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("1. Afficher la liste des étudiants");
            System.out.println("2. Afficher la moyenne générale de la promotion");
            System.out.println("3. Afficher la moyenne d'une UE");
            System.out.println("3. Ajouter un étudiant");
            System.out.println("4. Ajouter une note");
            System.out.println("5. Afficher le major de la promotion");
            System.out.println("6. Afficher le major d'une UE");
            System.out.println("7. Quitter");


            System.out.print("> ");
            int choix = sc.nextInt();
            menuChoiceHandler(choix, promo, sc);

        } while (true);



    }

    private static void menuChoiceHandler(int choix, Promotion promo, Scanner sc) {
        switch (choix){
            case 1:
                promo.afficherEtudiants();
                break;
            case 2:
                System.out.println("La moyenne générale de la promotion est de " + promo.moyenneGenerale());
                break;
            case 3:
                System.out.println("Quelle UE ?");
                String nomUE = sc.next();
                System.out.println("La moyenne de l'UE " + nomUE + " est de " + promo.moyenneUE(promo.getUE(nomUE)));
                break;
            case 4:
                System.out.println("Quel est le nom de l'étudiant ?");
                String nom = sc.next();
                System.out.println("Quel est le prénom de l'étudiant ?");
                String prenom = sc.next();
                System.out.println("Quelle est la note ?");
                double note = sc.nextDouble();
                System.out.println("Quelle est l'UE ?");
                String ue = sc.next();
                System.out.println("Quel est le type de note (CC ou EX) ?");
                String typeNote = sc.next();
                if (typeNote.equals("CC")) {
                    promo.getEtudiant(nom, prenom).ajouterNoteCC(promo.getUE(ue), note);
                } else {
                    promo.getEtudiant(nom, prenom).ajouterNoteEX(promo.getUE(ue), note);
                }
                break;
            case 5:
                System.out.println("Le major de la promotion est " + promo.meilleurEtudiant());
                break;
            case 6:
                System.out.println("Quelle UE ?");
                String nomUE2 = sc.next();
                System.out.println("Le major de l'UE " + nomUE2 + " est " + promo.meilleurEtudiantUE(promo.getUE(nomUE2)));
                break;
            case 7:
                System.out.println("Au revoir !");
                break;
            default:
                System.out.println("Choix invalide");
        }
    }
}
