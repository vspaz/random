package class_3;

import org.testng.annotations.Test;

import java.io.StringReader;

import static org.testng.Assert.*;

public class GuessNumGameTest {

    @Test
    public void testPlayGame() throws Exception {
        GuessNumGame game = new GuessNumGame();
        assertEquals(game.toInt("9"), 9);
    }

    @Test
    public void testPlayGameInvalidRange() throws Exception {
        GuessNumGame game = new GuessNumGame();
        assertThrows(Exception.class, () -> game.toInt("10"));
    }

    @Test
    public void testPlayGameNegativeInput() throws Exception {
        GuessNumGame game = new GuessNumGame();
        assertThrows(Exception.class, () -> game.toInt("-1"));
    }

    @Test
    public void testIsWinner() throws Exception {
        GuessNumGame game = new GuessNumGame();
        assertTrue(game.isWinner(9, new StringReader("9")));
    }

    @Test
    public void testIsExit() {
        GuessNumGame game = new GuessNumGame();
        assertTrue(game.isExit(new StringReader("0")));
        assertFalse(game.isExit(new StringReader("1")));
    }
}