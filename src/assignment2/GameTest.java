package assignment2;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by Eric on 9/18/16.
 */
public class GameTest {
    Game testGame = new Game(true);
    @Test
    public void testGeneratePeg1() {
        testGame.code = new String[] {"O", "O", "O", "O"};
        Peg p1 = testGame.generatePeg("OOOO");
        assertEquals(4, p1.Black);
        assertEquals(0, p1.White);

        Peg p2 = testGame.generatePeg("OOBB");
        assertEquals(2, p2.Black);
        assertEquals(0, p2.White);

        Peg p3 = testGame.generatePeg("OBBO");
        assertEquals(2, p3.Black);
        assertEquals(0, p3.White);

        Peg p4 = testGame.generatePeg("BBBB");
        assertEquals(0, p4.White);
        assertEquals(0, p4.Black);
    }

    @Test
    public void testGeneratePeg2() {
        testGame.code = new String[] {"O", "B", "B", "O"};
        Peg p1 = testGame.generatePeg("OOOO");
        assertEquals(2, p1.Black);
        assertEquals(0, p1.White);

        Peg p2 = testGame.generatePeg("OOBB");
        assertEquals(2, p2.Black);
        assertEquals(2, p2.White);

        Peg p3 = testGame.generatePeg("OBBO");
        assertEquals(4, p3.Black);
        assertEquals(0, p3.White);

        Peg p4 = testGame.generatePeg("BBBB");
        assertEquals(2, p4.Black);
        assertEquals(0, p4.White);
    }

    @Test
    public void testGeneratePeg3() {
        testGame.code = new String[] {"Y", "B", "B", "O"};
        Peg p1 = testGame.generatePeg("BYBO");
        assertEquals(2, p1.Black);
        assertEquals(2, p1.White);

        Peg p2 = testGame.generatePeg("BOYB");
        assertEquals(0, p2.Black);
        assertEquals(4, p2.White);

        Peg p3 = testGame.generatePeg("OBBO");
        assertEquals(3, p3.Black);
        assertEquals(0, p3.White);

        Peg p4 = testGame.generatePeg("BBBB");
        assertEquals(2, p4.Black);
        assertEquals(0, p4.White);
    }

    @Test
    public void testGeneratePegPiazza() {
        testGame.code = new String[] {"G", "Y", "R", "G"};
        Peg p1 = testGame.generatePeg("YGRG");
        assertEquals(2, p1.Black);
        assertEquals(2, p1.White);

        testGame.code = new String[] {"R", "Y", "B", "G"};
        Peg p2 = testGame.generatePeg("YRBG");
        assertEquals(2, p2.Black);
        assertEquals(2, p2.White);

        Peg p3 = testGame.generatePeg("YBYY");
        assertEquals(0, p3.Black);
        assertEquals(2, p3.White);

        Peg p4 = testGame.generatePeg("RRBB");
        assertEquals(2, p4.Black);
        assertEquals(0, p4.White);

    }
/*
    @Test
    public void testGenerate10() {
        GameConfiguration.pegNumber = 10;
        testGame.code = new String[] {"R", "R", "Y", "Y", "B", "B", "G", "G", "B", "R"};
        Peg p1 = testGame.generatePeg("RRYYGGBBRY");
        assertEquals(4, p1.Black);
        assertEquals(5, p1.White);
    }

    @Test
    public void testGenerate2() {
        GameConfiguration.pegNumber = 2;
        testGame.code = new String[] {"R", "Y"};
        Peg p1 = testGame.generatePeg("YY");
        assertEquals(1, p1.Black);
        assertEquals(0, p1.White);
    }

    @Test
    public void testGenerate6() {
        GameConfiguration.pegNumber = 6;
        testGame.code = new String[] {"R", "Y", "B", "G", "B", "B"};
        Peg p1 = testGame.generatePeg("RBYYYG");
        assertEquals(1, p1.Black);
        assertEquals(3, p1.White);
    }*/
}
