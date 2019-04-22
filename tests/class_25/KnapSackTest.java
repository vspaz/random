package class_25;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class KnapSackTest {

    @Test
    public void testKnapSack() {
        assertEquals(
                KnapSack.getTotalValue(100, new int[]{ 30, 10, 60, 100, 50}, new int[]{10, 15, 5, 5, 10}, 5),
                35);

    assertEquals(
            KnapSack.getTotalValue(40, new int[]{ 30, 10, 60, 100, 50}, new int[]{10, 15, 5, 5, 10}, 5),
            25);
    }
}
