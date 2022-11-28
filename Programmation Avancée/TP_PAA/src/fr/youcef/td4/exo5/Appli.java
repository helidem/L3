package fr.youcef.td4.exo5;

import fr.youcef.td4.exo3.GrepReader;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Appli {
    public static void main(String[] args) {
        // programme qui lit un fichier texte contenant les informations sur les programmes tv
        // et qui les affiche dans l'ordre chronologique
        // le fichier texte est de la forme:
        // divertissement(XXX, YYY, H) avec XXX le nom du présentateur, YYY le nom de l'émission et H l'heure de début de l'émission
        // journal(XXX, H1, H2) avec XXX le nom du présentateur, H1 l'heure de début de l'émission et H2 l'heure de fin de l'émission
        // reportage(XXX, YYY, H1, H2) avec XXX le thème, YYY le nom, H1 l'heure de début de l'émission et H2 l'heure de fin de l'émission
        // fiction(XXX, YYY, ZZZ, H1, H2) avec XXX le titre, YYY le nom du réalisateur, ZZZ un booléen indiquant si c'est une rediffusion, H1 l'heure de début de l'émission et H2 l'heure de fin de l'émission

        // exemple de fichier:
        /*
        divertissement(Nikos Aliagas,The Voice,12)
        journal(Gilles Bouleau,20,21)
        reportage(ACTUALITE,L’Université de Paris : l’avenir de l’informatique,11,12)
        fiction(Le Parrain,Francis Ford Coppola,T,14,16)
        fiction(Bohemian Rhapsody,Bryan Singer,F,21,23)
        fiction(Star Wars,George Lucas,T,23,01)
         */

        // rendu :
        /*
        L'Université de Paris : l'avenir de l'informatique reportage sur ACTUALITE, de 11h00 a 12h00.
        The Voice, presente par Nikos Aliagas de 12h00 à 14h00.
        Le Parrain realise par Francis Ford Coppola,de 12h00 a 16h00 rediffusion.
        Journal presente par Gilles Bouleau de 20h00 a 21h00.
        Bohemian Rhapsody realise par Bryan Singer,de 21h00 a 23h00 inedit.
        Star Wars realise par George Lucas,de 23h00 a 1h00 : rediffusion.
         */

        // on recupere le fichier
        // on le lit ligne par ligne
        // on stocke les informations dans un tableau
        // on trie le tableau par ordre chronologique
        // on affiche le tableau

        try {
            File textFile = new File(args[0]);
            GrepReader gr = new GrepReader(new FileReader(textFile));
            while(true) {
                String line = gr.readLine();
                if (line == null) {
                    break;
                }
                // System.out.println(line);
                String type = line.split("\\(")[0];
                ArrayList<String[]> infos = new ArrayList<>();
                switch (type) {
                        case "divertissement":
                            infos.add(line.split("\\(")[1].split(","));
                            break;
                        case "journal":
                            infos.add(line.split("\\(")[1].split(","));
                            break;
                        case "reportage":
                            infos.add(line.split("\\(")[1].split(","));
                            break;
                        case "fiction":
                            infos.add(line.split("\\(")[1].split(","));
                            break;
                        default:
                            System.out.println("Erreur de lecture du fichier");
                            break;
                }
                // trier le tableau par ordre chronologique des heures de debut
                infos.sort((o1, o2) -> Integer.parseInt(o1[2].trim()) - Integer.parseInt(o2[2].trim()));

                // afficher le tableau
                for (String[] info : infos) {
                    switch (type){
                        case "divertissement":
                            System.out.println(info[1].trim() + ", presente par " + info[0].trim() + " de " + info[2].trim() + "h00 a " + (Integer.parseInt(info[2].trim()) + 2) + "h00.");
                            break;
                        case "journal":
                            System.out.println("Journal presente par " + info[0].trim() + " de " + info[1].trim() + "h00 a " + info[2].trim() + "h00.");
                            break;
                        case "reportage":
                            System.out.println(info[1].trim() + " reportage sur " + info[0].trim() + ", de " + info[2].trim() + "h00 a " + info[3].trim() + "h00.");
                            break;
                        case "fiction":
                            System.out.println(info[0].trim() + " realise par " + info[1].trim() + ",de " + info[3].trim() + "h00 a " + info[4].trim() + "h00 " + (info[2].trim().equals("T") ? "rediffusion." : "inedit."));
                            break;
                        default:
                            System.out.println("Erreur de type");
                    }
                }



            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
