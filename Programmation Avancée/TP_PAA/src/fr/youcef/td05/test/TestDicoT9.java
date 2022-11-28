package fr.youcef.td05.test;

import fr.youcef.td03.exo1.DicoT9;
import org.junit.jupiter.api.Test;

import static fr.youcef.td02.UtilTD2.*;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestDicoT9 {

    @Test
    public void testEnregistrer() {
        // Given
        DicoT9 dico = new DicoT9();
        String mot = "bonjour";
        String expected = "[bonjour]";

        // When
        dico.enregistrer(mot);
        String actual = dico.recuperer(word2T9(mot)).toString();

        // Then
        assertEquals(expected, actual);

    }

    @Test
    public void testRecuperer() {
        // Given
        DicoT9 dico = new DicoT9();
        String code = "2665687";
        String code2 = "26663";
        String expected = "[bonjour]";
        String expected2 = "[bonne]";

        // When
        dico.enregistrer("bonjour");
        dico.enregistrer("bonne");
        String actual = dico.recuperer(code).toString();
        String actual2 = dico.recuperer(code2).toString();

        // Then
        assertEquals(expected, actual);
        assertEquals(expected2, actual2);

    }
}
