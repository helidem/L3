package fr.youcef.td03.exo3;

import fr.youcef.td02.Personne;
import fr.youcef.td4.exo4.RepertoireInvalide;

public class TestRepertoireAmeliore {
    public static void main(String[] args) {
        RepertoireAmeliore rep = new RepertoireAmeliore(
                new Personne("Jimi", "Hendrix", "0987654321"));
        try {
            rep.addPersonne("John", "Lennon", "0123456789");
            rep.addPersonne("Paul", "McCartney", "0234567891");
            rep.addPersonne("George", "Harrison", "0345678912");
            rep.addPersonne("Ringo", "Starr", "0456789123");
        } catch (RepertoireInvalide e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(rep.chercheNumero("John", "Lennon"));
            System.out.println(rep.chercheNumero("Freddie", "Mercury"));
            System.out.println(rep.cherchePersonne("0234567891"));
            System.out.println(rep.cherchePersonne("0234567899"));
        } catch (RepertoireInvalide e) {
            System.out.println(e.getMessage());
        }
        System.out.println(rep);
    }
}
