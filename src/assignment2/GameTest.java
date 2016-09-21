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
}
