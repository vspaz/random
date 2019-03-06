package class_2;

import org.testng.Assert;
import org.testng.annotations.Test;


import static org.testng.Assert.*;

public class ArrayPuzzlesTest {

    @Test
    public void testSwitchBinaryValues() {
        Assert.assertEquals(
                ArrayPuzzles.switchBinaryValues(new int[]{1, 1, 0, 0, 1, 0, 1, 0}),
                new int[]{0, 0, 1, 1, 0, 1, 0, 1});
    }

    @Test
    public void testGetItemsMultpleOfThree() {
        Assert.assertEquals(
                ArrayPuzzles.getItemsMultpleOfThree(),
                new int[]{0, 3, 6, 9, 12, 15, 18, 21});
    }

    @Test
    public void testCreateIdentityMatrix() {
        Assert.assertEquals(
                ArrayPuzzles.createIdentityMatrix(3, 3),
                new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}});
    }

    @Test
    public void testDoubleItemsLessThanSix() {
        Assert.assertEquals(
                ArrayPuzzles.doubleItemsLessThanSix(new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}),
                new int[]{2, 10, 6, 4, 11, 8, 10, 4, 8, 8, 9, 2});
    }

    @Test
    public void testGetMinAndMax() {
        Assert.assertEquals(
                ArrayPuzzles.getMinAndMax(new int[]{1, -5, 300, 2, 11, 4, 5, 2, 4, 8, 9, 100500}),
                new int[]{-5, 100500});
    }

    @Test
    public void testIsSplittableBySum() {
        assertTrue(ArrayPuzzles.isSplittableBySum(new int[]{5, 10, 5, 5, 5}));
        assertFalse(ArrayPuzzles.isSplittableBySum(new int[]{500, 10, 5, 5, 5}));
    }

    @Test
    public void testIsSplittableBySum2() {
        assertTrue(ArrayPuzzles.isSplittableBySum2(new int[]{5, 10, 5, 5, 5}));
        assertFalse(ArrayPuzzles.isSplittableBySum2(new int[]{500, 10, 5, 5, 5}));
        Assert.assertEquals(
                ArrayPuzzles.isSplittableBySum2(new int[]{5, 10, 5, 5, 5}),
                ArrayPuzzles.isSplittableBySum(new int[]{5, 10, 5, 5, 5}));
    }

    @Test
    public void testShiftArray() {
        int[] shiftedItemsByTreeRight = new int[]{4, 5, 6, 1, 2, 3};
        Assert.assertEquals(
                ArrayPuzzles.shiftArray(new int[]{1, 2, 3, 4, 5, 6}, 3),
                shiftedItemsByTreeRight);

        // rotate compeltely + shift 3 positions right.
        Assert.assertEquals(
                ArrayPuzzles.shiftArray(new int[]{1, 2, 3, 4, 5, 6}, 9),
                shiftedItemsByTreeRight);

        // shifted left
        Assert.assertEquals(
                ArrayPuzzles.shiftArray(new int[]{1, 2, 3, 4, 5, 6}, -4),
                new int[]{5, 6, 1, 2, 3, 4});

        // rotate completely
        Assert.assertEquals(ArrayPuzzles.shiftArray(new int[]{1, 2, 3, 4, 5, 6}, 6),
                new int[]{1, 2, 3, 4, 5, 6});
    }

    @Test
    public void testCreateOddNumArray() {
        int[] oddNums = ArrayPuzzles.createOddNumArray();

        assertEquals(oddNums.length, 50);

        assertEquals(oddNums[0], 1);
        assertEquals(oddNums[24], 49);
        assertEquals(oddNums[49], 99);

        // even nums not expected.
        for (int num : oddNums) {
            assertTrue(num != 0);
        }
    }

    @Test
    public void testGetOddAndEvenCount() {
        Assert.assertEquals(
                ArrayPuzzles.getOddAndEvenCount(new int[]{1, 3, 8, 9, 9, 2, 3, 4, 1, 2}),
                new int[]{6, 4});
    }

    @Test
    public void testGenerateRandNumsRange() {
        for (int randomNum : ArrayPuzzles.generateRandNums(15, 9))
            assertTrue(0 <= randomNum && randomNum <= 9);
    }

    @Test
    public void testGenerateRandNumsDistribution() {
        int[] randomNums = ArrayPuzzles.generateRandNums(1000, 9);
        int[] oddsAndEvenCount = ArrayPuzzles.getOddAndEvenCount(randomNums);

        // we don't expected equal distribution of nums
        // the import thing is that both types are present.
        int oddsCount = oddsAndEvenCount[0];
        assertTrue(oddsCount >= 100);

        int evenCount = oddsAndEvenCount[1];
        assertTrue(evenCount >= 100);
    }

    @Test
    public void testGetMean() {
        Assert.assertEquals(ArrayPuzzles.getMean(new int[]{2, 2, 3, 3, 10}), 4);
    }

    @Test
    public void testPrintMeansComparisonResults() {
        Assert.assertEquals(ArrayPuzzles.compareMeansOfTwoArrays(20, 10), "mean of %s > mean of %s");
        Assert.assertEquals(ArrayPuzzles.compareMeansOfTwoArrays(10, 20), "mean of %s < mean of %s");
        Assert.assertEquals(ArrayPuzzles.compareMeansOfTwoArrays(10, 10), "mean of %s = mean of %s");
    }
}
