package fr.youcef.td4.exo4;

import fr.youcef.td02.Personne;
import fr.youcef.td03.exo3.RepertoireAmeliore;

import java.io.File;
import java.io.FileWriter;

public class SauvegarderRepertoire {

    public static void saveRepertoire(String nomFichier, RepertoireAmeliore rep) {
        // regarder si le fichier existe déjà
        // si oui lancer une exception
        // sinon créer le fichier et écrire le contenu du répertoire
        // le fichier doit etre construit de la manière suivante:
        // proprietaire(XXX, YYY, ZZZ) avec XXX le prenom, YYY le nom et ZZZ le numéro de téléphone. cette ligne permet de définir un propriétaire.
        // la suite du fichier contient des lignes de la forme:
        // contact(XXX, YYY, ZZZ) avec XXX le prenom, YYY le nom et ZZZ le numéro de téléphone

        File file = new File(nomFichier);
        if (file.exists()) {
            throw new RuntimeException("Le fichier existe déjà");
        }

        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            Personne proprietaire = rep.getProprietaire();
            fw.write("proprietaire(" + proprietaire.getPrenom() + ", " + proprietaire.getNom() + ", " + proprietaire.getNumero() + ")\n");
            for(Personne contact : rep.getRepertoireSimple()){
                fw.write("contact(" + contact.getPrenom() + ", " + contact.getNom() + ", " + contact.getNumero() + ")\n");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fw.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
