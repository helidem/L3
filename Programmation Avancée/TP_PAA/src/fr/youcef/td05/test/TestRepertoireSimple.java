package fr.youcef.td05.test;

import fr.youcef.td02.RepertoireSimple;
import fr.youcef.td4.exo4.RepertoireInvalide;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestRepertoireSimple {

    @Test
    public void testAjouter() {
        // Given
        RepertoireSimple repertoire = new RepertoireSimple();
        String prenom = "Youcef";
        String nom = "Medileh";
        String numero = "0769166683";
        String expected = "Youcef Medileh : 0769166683";

        // When
        try {
            repertoire.addPersonne(nom, prenom, numero);
        } catch (RepertoireInvalide e) {
            throw new RuntimeException(e);
        }
        String actual = repertoire.getRepertoireSimple().get(0).getPrenom() + " " + repertoire.getRepertoireSimple().get(0).getNom() + " : " + repertoire.getRepertoireSimple().get(0).getNumero();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void testChercherNumero() {
        // Given
        RepertoireSimple repertoire = new RepertoireSimple();
        String prenom = "Youcef";
        String nom = "Medileh";
        String numero = "0769166683";
        String expected = "0769166683";
        String actual = "";
        // When
        try {
            repertoire.addPersonne(nom, prenom, numero);
            actual = repertoire.chercheNumero(nom, prenom);
        } catch (RepertoireInvalide e) {
            System.out.println(e.getMessage());
        }

        // Then
        assertEquals(expected, actual);

    }

}
