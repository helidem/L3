package fr.youcef.td4.exo4;

import fr.youcef.td02.Personne;
import fr.youcef.td03.exo3.RepertoireAmeliore;
import fr.youcef.td4.exo3.GrepReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ParserRepertoire {


    public static void lireRepertoire(String textfile) {
        // le fichier texte contient la chaine de caractères suivante:
        // proprietaire(XXX, YYY, ZZZ) avec XXX le prenom, YYY le nom et ZZZ le numéro de téléphone. cette ligne permet de définir un propriétaire.
        // la suite du fichier contient des lignes de la forme:
        // contact(XXX, YYY, ZZZ) avec XXX le prenom, YYY le nom et ZZZ le numéro de téléphone

        // lire le fichier texte
        // pour chaque ligne, si la ligne commence par "proprietaire", alors on crée un nouveau propriétaire
        // sinon, on crée un nouveau contact et on l'ajoute au propriétaire courant



        try {
            File file = new File(textfile);
            GrepReader gr = new GrepReader(new FileReader(file));
            RepertoireAmeliore repertoire = null;
            while (true) {
                String line = gr.readLine("proprietaire");
                if (line == null) {
                    break;
                }
                System.out.println(line);
                String prenom = line.substring(line.indexOf("(") + 1, line.indexOf(","));
                String nom = line.substring(line.indexOf(",") + 1, line.lastIndexOf(","));
                String numero = line.substring(line.lastIndexOf(",") + 1, line.lastIndexOf(")"));
                Personne proprietaire = new Personne(nom, prenom, numero);
                repertoire = new RepertoireAmeliore(proprietaire);
                while (true) {
                    String line2 = gr.readLine("contact");
                    if (line2 == null) {
                        break;
                    }
                    System.out.println(line2);
                    String prenom2 = line2.substring(line2.indexOf("(") + 1, line2.indexOf(","));
                    String nom2 = line2.substring(line2.indexOf(",") + 1, line2.lastIndexOf(","));
                    String numero2 = line2.substring(line2.lastIndexOf(",") + 1, line2.lastIndexOf(")"));
                    Personne contact = new Personne(nom2, prenom2, numero2); // inutile
                    try {
                        repertoire.addPersonne(nom2, prenom2, numero2);
                    } catch (RepertoireInvalide e) {
                        throw new RuntimeException(e);
                    }
                }

            }
            System.out.println(repertoire);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

}
