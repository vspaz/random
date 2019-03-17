package class_6;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringUtilsTest {

    @Test
    public void testRemoveTrailingSpaces() {
        assertEquals(
                StringUtils.punctuate("Предложение один два     "),
                "Предложение один два.");
    }

    @Test
    public void testRemoveLeadingSpaces() {
        assertEquals(
                StringUtils.punctuate("    Предложение один два"),
                "Предложение один два.");
    }

    @Test
    public void testRemoveExtraSpacesBetweenWords() {
        assertEquals(
                StringUtils.punctuate("Предложение      один       два"),
                "Предложение один два.");
    }

    @Test
    public void testAddDot() {
        assertEquals(
                StringUtils.punctuate("Предложение      Один       Два"),
                "Предложение. Один. Два.");
    }

    @Test
    public void testAddDotWithoutSpaces() {
        assertEquals(
                StringUtils.punctuate("Предложение Один Два"),
                "Предложение. Один. Два.");
    }

    @Test
    public void testAll() {
        assertEquals(
                StringUtils.punctuate("        Предложение      Oдин   Предложение два Предложение три          "),
                "Предложение. Oдин. Предложение два. Предложение три.");
    }

    @Test
    public void testStringOfOneChar() {
        assertEquals(
                StringUtils.punctuate("A"), "A.");
    }

    @Test
    public void testEmptyString() {
        assertEquals(
                StringUtils.punctuate(""), "");
    }

    @Test
    public void testSingleCharWithPadding() {
        assertEquals(
                StringUtils.punctuate("             M             "), "M.");
    }


    @Test
    public void testGetFirstNonEmptyCharIndex() {
        assertEquals(StringUtils.getFirstNonEmptyCharIndex("     hello"), 5);
    }

    @Test
    public void testGetFirstNonEmptyCharIndex_2() {
        assertEquals(StringUtils.getFirstNonEmptyCharIndex("hello"), 0);
    }

    @Test
    public void testAddTrailingDot() {
        assertEquals(StringUtils.addTrailingDot(new StringBuilder("foo")), "foo.");
    }

    @Test
    public void testNotAddTrailingDot() {
        assertEquals(StringUtils.addTrailingDot(new StringBuilder("foo.")), "foo.");
    }
}

