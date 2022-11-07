package fr.youcef.td01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UtilMath {
    public static void main(String[] args) {

        // System.out.println(listePremier(100));
        // jeuNombreSecret();

        cmd2();
    }

    // exercice 1

    public static int somme3(int a, int b, int c) {
        return a + b + c;
    }

    public static long fact(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("n doit être positif");
        }

        if (n == 0) {
            return 1;
        } else return (n * fact(n - 1));
    }

    public static long comb(int n, int p) throws IllegalArgumentException {
        if (p > n) {
            throw new IllegalArgumentException("p doit être inférieur à n");
        }
        assert (n >= 0 && p >= 0);
        return fact(n) / fact(p) * fact(n - p);
    }

    public static long puissance(int n, int m) throws IllegalArgumentException {
        if (m < 0) {
            throw new IllegalArgumentException("m doit être positif");
        }
        if (m == 0)
            return 1;
        else
            return n * puissance(n, m - 1);
    }

    // exercice 2

    public static int max2(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int max3v1(int a, int b, int c) {
        int max = (a > b) ? a : b;
        if (c > max)
            return c;
        else
            return max;
    }

    public static int max3v2(int a, int b, int c) {
        return max2(max2(a, b), c);
    }

    // exercice 3

    public static double moyenne(double[] tab) {
        return UtilTab.somme(tab) / tab.length;
    }

    public static double mediane(double[] tab) {
        UtilTab.triParSelection(tab);
        if (tab.length % 2 == 0) {
            return (tab[(tab.length / 2) - 1] + tab[tab.length / 2]) / 2;
        } else {
            return tab[tab.length / 2];
        }
    }

    public static double moyennePonderee(double[] tab, int[] coef) {
        double somme = 0;
        for (int i = 0; i < tab.length; i++) {
            somme += tab[i] * coef[i];
        }
        return somme / tab.length;
    }

    // exercice 4

    public static double noteFinale(double moyenne, double exam) {
        return (exam > moyenne) ? exam : ((moyenne + exam) / 2);
    }

    public static double moyenneEtudiants(double[] tab) {
        double somme = 0;
        for (int i = 0; i < tab.length; i = i + 2) {
            somme += noteFinale(tab[i], tab[i + 1]);
        }
        return somme / (tab.length / 2);
    }

    // exercice 5

    public static String formatage(int nombre) {
        assert (nombre < 10000);
        StringBuilder sb = new StringBuilder();
        if (nombre < 10) {
            sb.append("   ").append(nombre);
        } else if (nombre < 100) {
            sb.append("  ").append(nombre);
        } else if (nombre < 1000) {
            sb.append(" ").append(nombre);
        }
        return sb.toString();
    }

    // exercice 6

    public static void cmd() {
        System.out.println("Commandes disponibles : ");
        System.out.println(" - somme de 3 entiers");
        System.out.println(" - factorielle");
        System.out.println(" - combinaison");
        System.out.println(" - puissance");
        System.out.print("> ");
        Scanner in = new Scanner(System.in);
        String choix = in.nextLine();
        switch (choix) {
            case "1":
                System.out.println("Entrez 3 entiers (appuyer sur entrée à chaque fois) : ");
                int a = in.nextInt();
                int b = in.nextInt();
                int c = in.nextInt();
                System.out.println(somme3(a, b, c));
                break;
            case "2":
                System.out.println("Entrez un entier : ");
                int n = in.nextInt();
                System.out.println(fact(n));
                break;
            case "3":
                System.out.println("Entrez 2 entiers : ");
                int n1 = in.nextInt();
                int p = in.nextInt();
                System.out.println(comb(n1, p));
                break;
            case "4":
                System.out.println("Entrez 2 entiers : ");
                int n2 = in.nextInt();
                int m = in.nextInt();
                System.out.println(puissance(n2, m));
                break;
            default:
                System.out.println("Commande inconnue");
        }
    }

    public static void cmd2() {
        do {
            System.out.println("Commandes disponibles : ");
            System.out.println(" - somme de 3 entiers");
            System.out.println(" - factorielle");
            System.out.println(" - combinaison");
            System.out.println(" - puissance");
            System.out.println(" - quitter");
            System.out.print("> ");
            Scanner in = new Scanner(System.in);
            String choix = in.nextLine();
            switch (choix) {
                case "1":
                    System.out.print("Entrez 3 entiers : ");
                    int a = 0;
                    int b = 0;
                    int c = 0;
                    try {
                        a = in.nextInt();
                        b = in.nextInt();
                        c = in.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println(somme3(a, b, c));
                    break;
                case "2":
                    System.out.print("Entrez un entier : ");
                    try {
                        int n = in.nextInt();
                        System.out.println(fact(n));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("Entier invalide");
                    }
                    break;
                case "3":
                    System.out.print("Entrez 2 entiers : ");
                    int n1 = in.nextInt();
                    int p = in.nextInt();
                    try {
                        System.out.println(comb(n1, p));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("Entier invalide");
                    }
                    break;
                case "4":
                    System.out.print("Entrez 2 entiers : ");
                    int n2 = in.nextInt();
                    int m = in.nextInt();
                    try {
                        System.out.println(puissance(n2, m));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("Entier invalide");
                    }
                    break;
                case "5":
                    System.out.println("Au revoir");
                    return;
                default:
                    System.out.println("Commande inconnue");
            }
        } while (true);
    }

    // exercice 7

    public static void cmdEtudiants() {
        do {
            System.out.println("Commandes disponibles : ");
            System.out.println(" - moyenne d'un étudiant");
            System.out.println(" - moyenne d'un groupe");
            System.out.println(" - quitter");
            System.out.print("> ");
            Scanner in = new Scanner(System.in);
            String choix = in.nextLine();
            switch (choix) {
                case "1":
                    System.out.print("Entrez la moyenne et la note de l'examen : ");
                    double moyenne = in.nextDouble();
                    double exam = in.nextDouble();
                    System.out.println("La moyenne de l'etudiant est de : " + noteFinale(moyenne, exam) + "/20");
                    break;
                case "2":
                    System.out.print("Entrez le nombre d'étudiants : ");
                    int nbEtudiants = in.nextInt();
                    double[] tab = new double[nbEtudiants * 2];
                    for (int i = 0; i < tab.length; i = i + 2) {
                        System.out.print("Entrez la moyenne et la note de l'examen de l'étudiant " + (i / 2 + 1) + " : ");
                        tab[i] = in.nextDouble();
                        tab[i + 1] = in.nextDouble();
                    }
                    System.out.println("La moyenne du groupe est de : " + moyenneEtudiants(tab) + "/20");
                    break;
                case "3":
                    System.out.println("Au revoir");
                    return;
                default:
                    System.err.println("Commande inconnue");
            }
        } while (true);
    }

    // exercice 8

    public static boolean estPremierv1(int n) {
        assert (n > 0);
        if (n == 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean estPremierv2(int n) {
        assert (n > 0);
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i < n; i = i + 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean estPremierv3(int n) {
        assert (n > 0);
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n); i = i + 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String listePremier(int n) {
        String liste = "";
        for (int i = 1; i <= n; i++) {
            if (estPremierv3(i)) {
                liste = liste + i + " ";
            }
        }
        return liste;
    }

    // exercice 9

    public static void jeuNombreSecret() {
        System.out.println("pensez à un nombre entre 1 et 100");
        int max = 100;
        int min = 0;
        int milieu;
        do {
            milieu = (max + min) / 2;
            System.out.println("Ma proposition est " + milieu);
            Scanner in = new Scanner(System.in);
            String res = in.nextLine();
            switch (res) {
                case "=":
                    System.out.println("J'ai gagné !");
                    return;
                case "+":
                    min = milieu + 1;
                    break;
                case "-":
                    max = milieu - 1;
                    break;
                default:
                    System.out.println("Je n'ai pas compris");
            }
        } while (true);
    }

    // exercice 10

    /**
     * Méthode qui trie un tableau d'entiers par ordre croissant
     *
     * @param t       le tableau à trier
     * @param iMin    l'indice du premier élément à trier
     * @param iMilieu l'indice du milieu du tableau (qui divise le tableau en 2)
     * @param iMax    l'indice du dernier élément à trier
     */
    public static void fusion(int[] t, int iMin, int iMilieu, int iMax) {
        int[] t1 = new int[iMilieu - iMin + 1];
        int[] t2 = new int[iMax - iMilieu];
        int[] temp = new int[t.length];
        for (int i = 0; i < t1.length; i++) {
            t1[i] = t[iMin + i];
        }
        for (int i = 0; i < t2.length; i++) {
            t2[i] = t[iMilieu + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = iMin;
        while (i < t1.length && j < t2.length) {
            if (t1[i] <= t2[j]) {
                System.out.println("t1[" + i + "] = " + t1[i] + " <= t2[" + j + "] = " + t2[j]);
                temp[k] = t1[i];
                i++;
            } else {
                System.out.println("t1[" + i + "] = " + t1[i] + " > t2[" + j + "] = " + t2[j]);
                temp[k] = t2[j];
                j++;
            }
            k++;

        }
        while (i < t1.length) {
            temp[k] = t1[i];
            k++;
            i++;
        }
        while (j < t2.length) {
            temp[k] = t2[j];
            k++;
            j++;
        }

        for (int l = iMin; l <= iMax; l++) {
            t[l] = temp[l];
            System.out.println(t[l]);
        }
    }

    public static void triFusion(int[] t, int iMin, int iMax) {
        if (iMin < iMax) {
            int iMilieu = (iMin + iMax) / 2;
            triFusion(t, iMin, iMilieu);
            triFusion(t, iMilieu + 1, iMax);
            fusion(t, iMin, iMilieu, iMax);
        }
    }
}
