package fr.youcef.td4.exo3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Appli {
    public static void main(String[] args) {

        try {
            GrepReader gr = new GrepReader(new FileReader(args[0]));
            while (true) {
                String line = gr.readLine(args[1]);
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Fin du programme");
        }
    }
}
