package class_3;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class InfixCalculatorTest {

    @Test
    public void testIsDouble() {
        InfixCalculator calc = new InfixCalculator();
        assertTrue(calc.isDouble("50"));
        assertFalse(calc.isDouble("foo"));
    }

    @Test
    public void testIsOp() {
        InfixCalculator calc = new InfixCalculator();
        assertTrue(calc.isOp("**"));
        assertFalse(calc.isOp("***"));
    }

    @Test
    public void testGetRet() {
        InfixCalculator calc = new InfixCalculator();
        assertEquals(calc.getRet("( 2 + ( 10 ** 2 ) )"), "102.0");
        assertEquals(calc.getRet("( 2 + ( 10 - 1 ) )"), "11");
        assertEquals(calc.getRet("( ( 2 ** 2 ) + ( 10 ** 10 ) - 50 )"), "54");
    }
}