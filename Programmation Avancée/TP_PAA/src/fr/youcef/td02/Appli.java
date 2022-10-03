package fr.youcef.td02;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Appli {
    public static void main(String[] args) {
        jeu();
    }

    public static void jeu() {

        System.out.println("Bienvenue dans le jeu !");
        System.out.println("Choisissez votre personnage :");
        System.out.println("1. Cooler (100 pv, 5 attaques avec Supernova, 8 attaques avec Rayon occulaire)");
        System.out.println("2. Vegeta (120 pv, 6 attaques avec Final Flash, 12 attaques avec Big Bang)");
        System.out.println("3. Nappa (90 pv, 8 attaques avec Tempête de boules d'énergie, 5 attaques avec Kamehameha)");
        System.out.println("4. Goku (100 pv, 5 attaques avec Kamehameha, 3 attaques avec Kaioken)");
        System.out.print("> ");
        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();

        Personnage perso = choixPersonnage(choix);
        // l'IA choisit un personnage au hasard
        int choixIA = (int) (Math.random() * 3) + 1;
        Personnage persoIA = choixPersonnage(choixIA);

        System.out.println("Vous avez choisi " + perso.getNom() + " contre " + persoIA.getNom());
        int tour = 0;
        // le jeu commence

        do {
            // affichage des pv et des attaques disponibles
            // le joueur choisit une attaque
            // le jeu regarde si l'attaque est possible (endurance > 0)
            // si oui, l'attaque est effectuée
            // si non, le joueur doit choisir une autre attaque
            // si l'attaque est possible, l'endurance est décrémentée
            // si l'attaque est fatale, le jeu s'arrête et affiche le vainqueur
            // si l'attaque n'est pas fatale, l'IA attaque avec les mêmes règles

            System.out.println("=============[ TOUR " + tour + "]=============");
            // System.out.println(perso);
            // System.out.println("==Ennemi==");
            // System.out.println(persoIA);
            // jauge de vie des personnages avec des étoiles
            System.out.println("==Vos PV==");
            System.out.println(perso.getNom() + " : " + etoiles(perso));
            System.out.println("==Ennemi==");
            System.out.println(persoIA.getNom() + " : " + etoiles(persoIA));
            System.out.println("Choisissez votre attaque :");
            System.out.println("1. " + perso.getArme1().getNom() + " (" + perso.getArme1().getDegats() + " dégats, " + perso.getArme1().getEndurance() + " endurance)");
            System.out.println("2. " + perso.getArme2().getNom() + " (" + perso.getArme2().getDegats() + " dégats, " + perso.getArme2().getEndurance() + " endurance)");

            System.out.print("> ");
            int choixAttaque = sc.nextInt();
            Arme arme = choixAttaque(choixAttaque, perso);

            if (attaquePossible(arme)) {
                attaque(arme, persoIA);
                tour++;
                if (persoIA.isDead()) {
                    System.out.println("Vous avez gagné !");
                    break;
                }
                System.out.println("==Ennemi==");
                System.out.println(persoIA);
                System.out.println("L'ennemi attaque !");
                int choixAttaqueIA = (int) (Math.random() * 2) + 1;
                Arme armeIA = choixAttaque(choixAttaqueIA, persoIA);

                if (attaquePossible(armeIA)) {
                    attaque(armeIA, perso);
                    tour++;
                    if (perso.isDead()) {
                        System.out.println("Vous avez perdu !");
                        break;
                    }
                }

                // recap des attaques
                System.out.println("=============[ ATTAQUES ]=============");
                System.out.println("Vous avez attaqué " + persoIA.getNom() + " avec " + arme.getNom() + " et lui avez infligé " + arme.getDegats() + " dégats. Il lui reste " + persoIA.getPv() + " points de vie.");
                System.out.println("L'ennemi vous a attaqué avec " + armeIA.getNom() + " et vous a infligé " + armeIA.getDegats() + " dégats. Il vous reste " + perso.getPv() + " points de vie.");
                System.out.println("=====================================");
            }

        } while (!partieFinie(perso, persoIA));

    }

    private static String etoiles(Personnage personnage) {
        int pourcentage;
        pourcentage = (personnage.getPv()*10)/personnage.getPvMax();
        String etoiles = "";
        for (int i = 0; i < pourcentage; i++) {
            etoiles += "*";
        }
        String res = "";
        // affiche les étoiles mais aussi les espaces manquants
        for (int i = 0; i < 10; i++) {
            if (i < pourcentage) {
                res += "*";
            } else {
                res += " ";
            }
        }
        return "["+res+"]";
    }

    private static void attaque(Arme arme, Personnage perso) {
        perso.setPv(perso.getPv() - arme.getDegats());
        arme.setEndurance(arme.getEndurance() - 1);
    }

    private static boolean attaquePossible(Arme arme) {
        return arme.getEndurance() > 0 && arme != null;
    }

    public static Personnage choixPersonnage(int choix) {
        Personnage perso = null;
        switch (choix) {
            case 1:
                perso = new Personnage("Cooler", 100, new Arme("Supernova", 20, 5), new Arme("Rayon occulaire", 5, 8));
                break;
            case 2:
                perso = new Personnage("Vegeta", 120, new Arme("Final Flash", 12, 6), new Arme("Big Bang", 9, 12));
                break;
            case 3:
                perso = new Personnage("Nappa", 90, new Arme("Tempête de boules d'énergie", 8, 8), new Arme("Kamehameha", 15, 5));
                break;
                case 4:
                perso = new Personnage("Goku", 100, new Arme("Kamehameha", 15, 5), new Arme("Kaioken", 20, 3));

            default:
                System.out.println("Choix invalide");
                break;
        }
        return perso;
    }

    public static boolean partieFinie(Personnage perso, Personnage persoIA) {
        return perso.isDead() || persoIA.isDead();
    }

    public static Arme choixAttaque(int choix, Personnage perso) {
        Arme arme = null;
        switch (choix) {
            case 1:
                arme = perso.getArme1();
                break;
            case 2:
                arme = perso.getArme2();
                break;
            default:
                System.out.println("Choix invalide");
                break;
        }
        return arme;
    }

}

