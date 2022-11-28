package fr.youcef.td05.test;


import fr.youcef.td02.Personne;
import fr.youcef.td02.RepertoireSimple;
import fr.youcef.td03.exo3.RepertoireAmeliore;
import fr.youcef.td4.exo4.RepertoireInvalide;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestRepertoireAmeliore {

    @Test
    public void testCherchePersonne() {
        // Given
        RepertoireAmeliore repertoire = new RepertoireAmeliore(
                new Personne("Youcef", "Medileh", "0769166683"));
        try {
            repertoire.addPersonne("Jordan", "Malcles", "0102030405");
            repertoire.addPersonne("Paul", "McCartney", "0234567891");
        } catch (RepertoireInvalide e) {
            throw new RuntimeException(e);
        }

        String expected = "Jordan Malcles";
        String actual = "";

        // When
        try {
            actual = repertoire.cherchePersonne("0102030405");
        } catch (RepertoireInvalide e) {
            System.out.println(e.getMessage());
        }

        // Then
        assertEquals(expected, actual);


    }

    @Test
    public void testToString() {
        // Given
        RepertoireAmeliore repertoire = new RepertoireAmeliore(
                new Personne("Medileh", "Youcef", "0769166683"));
        try {
            repertoire.addPersonne("Malcles", "Jordan", "0102030405");
            repertoire.addPersonne("McCartney", "Paul", "0234567891");
        } catch (RepertoireInvalide e) {
            throw new RuntimeException(e);
        }
        String expected = "Propriétaire : Medileh Youcef 0769166683\nMalcles Jordan 0102030405\nMcCartney Paul 0234567891\n";
        String actual = "";

        // When
        actual = repertoire.toString();

        // Then
        assertEquals(expected, actual);


    }

}
