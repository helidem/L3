package fr.youcef.td4.exo2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class du {
    public static void main(String[] args) {
        // affiche la taille d'un fichier
        // si le fichier n'existe pas, on affiche un message d'erreur

        String nomFichier = args[0];

        try {
            File fichier = new File(nomFichier);
            System.out.println(fichier.length()+" octets");
        } catch (Exception e) {
            System.err.println("Erreur lors de la lecture du fichier " + nomFichier);
            e.printStackTrace();
        }
    }
}
