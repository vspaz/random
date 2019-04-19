package class_25;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BasicMathTest {

    @Test
    public void testToPowerPositive() {
        assertEquals(BasicMath.toPower(2, 3), 8);
    }

    @Test
    public void testToPowerZero() {
        assertEquals(BasicMath.toPower(8, 0), 1);
    }

    @Test
    public void testToPowerNegative() {
        assertThrows(AssertionError.class, () -> BasicMath.toPower(8, -1));
    }
}
