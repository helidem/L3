package fr.youcef.td02;

import up.mi.jgm.maths.*;

import java.util.ArrayList;
import java.util.HashMap;

public class UtilTD2 {
    public static void main(String[] args) {
        /*System.out.println("Exercice 1");
        System.out.println(puissance(new Rationnel(2), 3));
        System.out.println(sommeComplexe(new Complexe(2, 4), new Complexe(4, 8)));
        System.out.println(multiplicationComplexe(new Complexe(2, 4), new Complexe(4, 8)));
        System.out.println("Exercice 2");
        Point A = new Point(1, 1);
        Point B = new Point(3, 1);
        Point C = new Point(-4, 1);
        Point D = new Point(0, 1);
        Disque d1 = new Disque(A, A.distance(B));
        Disque d2 = new Disque(C, C.distance(D));
        System.out.println(d1.enIntersection(d2));
        System.out.println(word2T9("bonjour"));
        System.out.println("==================");*/
        HashMap<String, ArrayList<String>> dico = new HashMap<>();
        enregistrer(dico, "bonjour");
        enregistrer(dico, "bonne");
        enregistrer(dico, "comme");
        System.out.println(recuperer(dico, "26663"));
        System.out.println(recuperer(dico, "2665687"));
        System.out.println(recuperer(dico, "123456"));

    }

    // Exercice 1

    /**
     * Methode qui calcule la puissabce n-ieme d'un rationnel
     *
     * @param r le rationnel dont on veut calculer la puissance
     * @param n l'exposant
     * @return le rationnel r^n
     */
    public static Rationnel puissance(Rationnel r, int n) {
        Rationnel tmp = new Rationnel(1, 1);
        for (int i = 0; i < n; i++) {
            tmp = tmp.multiplication(r);
        }
        return tmp;
    }

    /**
     * Méthode qui fait la somme de deux nombres complexes
     *
     * @param c1 le premier nombre complexe
     * @param c2 le deuxieme nombre complexe
     * @return la somme des deux nombres complexes
     */
    public static Complexe sommeComplexe(Complexe c1, Complexe c2) {
        return new Complexe(c1.getPartieReelle() + c2.getPartieReelle(), c1.getPartieImaginaire() + c2.getPartieImaginaire());
    }

    public static Complexe multiplicationComplexe(Complexe c1, Complexe c2) {
        return new Complexe((c1.getPartieReelle() * c2.getPartieReelle()) - (c1.getPartieImaginaire() * c2.getPartieImaginaire()),
                (c1.getPartieReelle() * c2.getPartieImaginaire()) + (c1.getPartieReelle() * c2.getPartieImaginaire()));
    }

    // Exercice 7

    public static byte getChiffreT9(char c) {
        switch (Character.toLowerCase(c)) {
            case 'a':
            case 'b':
            case 'c':
                return 2;
            case 'd':
            case 'e':
            case 'f':
                return 3;
            case 'g':
            case 'h':
            case 'i':
                return 4;
            case 'j':
            case 'k':
            case 'l':
                return 5;
            case 'm':
            case 'n':
            case 'o':
                return 6;
            case 'p':
            case 'q':
            case 'r':
            case 's':
                return 7;
            case 't':
            case 'u':
            case 'v':
                return 8;
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                return 9;
            default:
                return 0;
        }
    }

    public static String word2T9(String mot) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mot.length(); i++) {
            sb.append(getChiffreT9(mot.charAt(i)));
        }
        return sb.toString();
    }

    public static void enregistrer(HashMap<String, ArrayList<String>> dico, String chaine) {
        if (dico.containsKey(word2T9(chaine))) {
            dico.get(word2T9(chaine)).add(chaine);
        } else {
            ArrayList<String> tmp = new ArrayList<>();
            tmp.add(chaine);
            dico.put(word2T9(chaine), tmp);
        }
    }

    public static ArrayList recuperer(HashMap<String, ArrayList<String>> dico, String chaineT9) {
        return (dico.get(chaineT9) == null) ? new ArrayList() : dico.get(chaineT9);
    }
}
