package fr.youcef.td4.exo2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class cp {
    public static void main(String[] args) {
        // programme qui prends en entrée deux noms de fichiers, et copie le contenu du premier dans le second
        // si le second n'existe pas, il est créé
        // si le second existe, il est écrasé
        // si le premier n'existe pas, on affiche un message d'erreur

        String nomFichier1 = args[0];
        String nomFichier2 = args[1];

        File fichier1 = new File(nomFichier1);
        File fichier2 = new File(nomFichier2);

        if (fichier1.exists()) {
            if (fichier2.exists()) {
                System.out.println("Le fichier " + nomFichier2 + " existe déjà, il va être écrasé.");
            } else {
                System.out.println("Le fichier " + nomFichier2 + " va être créé.");
                try {
                    fichier2.createNewFile();
                } catch (IOException e) {
                    System.err.println("Erreur lors de la création du fichier " + nomFichier2);
                    e.printStackTrace();
                }
            }
            try {
                FileWriter fw = new FileWriter(fichier2);
                FileReader fr = new FileReader(fichier1);
                int c;
                while ((c = fr.read()) != -1) {
                    fw.write(c);
                    fw.flush();
                }
                fw.close();
                fr.close();
            } catch (IOException e) {
                System.err.println("Erreur lors de la création du fichier " + nomFichier2);
                e.printStackTrace();
            }
        } else {
            System.out.println("Le fichier " + nomFichier1 + " n'existe pas, on ne peut pas le copier.");
        }

    }
}
