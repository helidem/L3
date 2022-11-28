package fr.youcef.td05.test;

import org.junit.jupiter.api.Test;
import fr.youcef.td01.UtilMath;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUtilMath {

    @Test
    public void testFact(){
        // Given
        int n = 5;
        long expected = 120;

        // When
        long actual = UtilMath.fact(n);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void testComb(){
        // Given
        int n = 5;
        int p = 3;
        long expected = 10;

        // When
        long actual = UtilMath.comb(n, p);

        // Then
        assertEquals(expected, actual);
    }
}
