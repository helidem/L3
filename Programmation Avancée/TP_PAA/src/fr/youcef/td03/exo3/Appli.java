package fr.youcef.td03.exo3;

import fr.youcef.td02.Personne;
import fr.youcef.td4.exo4.ParserRepertoire;
import fr.youcef.td4.exo4.RepertoireInvalide;
import fr.youcef.td4.exo4.SauvegarderRepertoire;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Appli {
    public static void main(String[] args) {
        cmd();
    }

    public static void cmd() {
        do {
            System.out.println("Commandes disponibles : ");
            System.out.println("1 - Créer un répertoire");
            System.out.println("2 - Ajouter un contact");
            System.out.println("3 - Chercher un contact (numero)");
            System.out.println("4 - Chercher un contact (nom et prénom)");
            System.out.println("5 - Afficher le répertoire");
            System.out.println("6 - Sauvegarder le répertoire");
            System.out.println("7 - Charger un répertoire");
            System.out.println("8 - Quitter");

            System.out.print("> ");
            Scanner in = new Scanner(System.in);
            String choix = in.nextLine();
            RepertoireAmeliore repertoire = null;
            switch (choix) {
                case "1":
                    System.out.println("Création d'un répertoire");
                    System.out.print("Nom du propriétaire : ");
                    String nom = in.nextLine();
                    System.out.print("Prénom du propriétaire : ");
                    String prenom = in.nextLine();
                    System.out.print("Numéro du propriétaire : ");
                    String numero = in.nextLine();
                    Personne proprietaire = new Personne(nom, prenom, numero);
                    repertoire = new RepertoireAmeliore(proprietaire);
                    break;
                case "2":
                    System.out.println("Ajout d'un contact");
                    System.out.print("Nom du contact : ");
                    String nom2 = in.nextLine();
                    System.out.print("Prénom du contact : ");
                    String prenom2 = in.nextLine();
                    System.out.print("Numéro du contact : ");
                    String numero2 = in.nextLine();
                    try {
                        repertoire.addPersonne(nom2, prenom2, numero2);
                    } catch (RepertoireInvalide e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "3":
                    System.out.println("Recherche d'un contact");
                    System.out.println("Numéro du contact : ");
                    String numero3 = in.nextLine();
                    String contact = null;
                    try {
                        contact = repertoire.cherchePersonne(numero3);
                        String[] contactSplit = contact.split(" ");
                        Personne personne = new Personne(contactSplit[0], contactSplit[1], numero3);
                        System.out.println("La personne recherchée est : " + personne);
                    } catch (RepertoireInvalide e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "4":
                    System.out.println("Recherche d'un contact");
                    System.out.println("Nom du contact : ");
                    String nom4 = in.nextLine();
                    System.out.println("Prénom du contact : ");
                    String prenom4 = in.nextLine();
                    try {
                        String num4 = repertoire.chercheNumero(nom4, prenom4);
                        Personne personne = new Personne(nom4, prenom4, num4);
                        System.out.println("La personne recherchée est : " + personne);
                    } catch (RepertoireInvalide e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "5":
                    System.out.println("Affichage du répertoire");
                    System.out.println(repertoire);
                    break;
                case "6":
                    System.out.println("Sauvegarde du répertoire");
                    System.out.println("Nom du fichier : ");
                    String nomFichier = in.nextLine();
                    try {
                        SauvegarderRepertoire.saveRepertoire(nomFichier, repertoire);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "7":
                    System.out.println("Chargement d'un répertoire");
                    System.out.println("Nom du fichier : ");
                    String nomFichier2 = in.nextLine();
                    try {
                        ParserRepertoire.lireRepertoire(nomFichier2);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "8":
                    System.out.println("Au revoir !");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Commande inconnue");
            }
        } while (true);
    }
}
