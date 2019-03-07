package class_3;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GuessWordGameTest {

    @Test
    public void testPlayGame() {
        GuessWordGame wordGame = new GuessWordGame();

        assertEquals(wordGame.getCommonPrefix("apple", "apfel"), "ap");
        assertEquals(wordGame.getCommonPrefix("foo", "bar"), "");
    }
}