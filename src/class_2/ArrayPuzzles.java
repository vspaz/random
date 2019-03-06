package class_2;

import java.util.Arrays;
import java.util.Random;

public class ArrayPuzzles {
    static int[] switchBinaryValues(int[] binaryValues) {
        for (int i = 0; i < binaryValues.length; i++) {
            if (binaryValues[i] == 1) binaryValues[i] = 0;
            else binaryValues[i] = 1;
        }
        return binaryValues;
    }

    static int[] getItemsMultpleOfThree() {
        int[] items = new int[8];
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            items[i] = count;
            count += 3;
        }
        return items;
    }

    static int[] doubleItemsLessThanSix(int[] items) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] < 6) {
                items[i] *= 2;
            }
        }
        return items;
    }

    static int[][] createIdentityMatrix(int rows, int cols) {
        int[][] idendityMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == j) idendityMatrix[i][j] = 1;
                else idendityMatrix[i][j] = 0;
            }
        }
        return idendityMatrix;
    }

    static int[] getMinAndMax(int[] items) {
        int min = items[0];
        int max = items[0];
        for (int i = 1; i < items.length; i++) {
            if (items[i] > max) max = items[i];
            else if (items[i] < min) min = items[i];
        }
        return new int[]{min, max};
    }

    static boolean isSplittableBySum(int[] items) {
        int leftHalfSum = 0;

        for (int i = 0; i < items.length; i++) {
            leftHalfSum += items[i];
            int rightHalfSum = 0;
            for (int j = i + 1; j < items.length; j++)
                rightHalfSum += items[j];
            if (rightHalfSum == leftHalfSum)
                return true;
        }
        return false;
    }

    // improvement on top of isSplittableBySum
    static boolean isSplittableBySum2(int [] items) {
        int total = 0;
        for (int item : items) {
            total += item;
        }

        int leftTotal = 0;
        for (int item : items) {
            total -= item;
            leftTotal += item;
            if (leftTotal == total)
                return true;
        }
        return false;
    }

    private static int[] shiftArrayLeft(int[] items, int pos) {
        for (int i = 0; i < pos; i++) {
            int temp = items[0];
            for (int j = 0; j < items.length - 1; j++) {
                items[j] = items[j + 1];
            }
            items[items.length - 1] = temp;
        }
        return items;
    }

    private static int[] shiftArrayRight(int[] items, int pos) {
        for (int i = 0; i < pos; i++) {
            int temp = items[items.length - 1];
            for (int j = items.length - 1; j > 0; j--) {
                items[j] = items[j - 1];
            }
            items[0] = temp;
        }
        return items;
    }

    static int[] shiftArray(int[] items, int pos) {
        if (pos > 0) {
            return shiftArrayRight(items, pos);
        } else if (pos < 0) {
            return shiftArrayLeft(items, -pos);
        } else {
            return items;
        }
    }

    // extra assignments

    static int[] createOddNumArray() {
        int[] oddNums = new int[50];
        int idx = 0;
        for (int i = 1; i < 100; i++) {
            if (i % 2 != 0) {
                oddNums[idx] = i;
                idx++;
            }
        }
        return oddNums;
    }

    static int[] generateRandNums(int size, int cap) {
        Random rand = new Random();
        int[] randomNums = new int[size];
        for (int i = 0; i < randomNums.length; i++) {
            randomNums[i] = rand.nextInt(cap);
        }

        return randomNums;
    }

    static int[] getOddAndEvenCount(int[] items) {
        int oddCount = 0;
        int evenCount = 0;

        for (int item : items) {
            if (item % 2 == 0) evenCount++;
            else oddCount++;
        }
        return new int[]{oddCount, evenCount};
    }

    static int getMean(int[] items) {
        int total = 0;
        for (int item : items) {
            total += item;
        }
        return total / items.length;
    }

    static String compareMeansOfTwoArrays(int mean1, int mean2) {
        if (mean1 > mean2)
            return "mean of %s > mean of %s";
        else if (mean1 < mean2)
            return "mean of %s < mean of %s";
        else
            return "mean of %s = mean of %s";
    }

    static void printMeansComparisonResults() {
        int[] array1 = generateRandNums(5, 5);
        int array1Mean = getMean(array1);

        int[] array2 = generateRandNums(5, 5);
        int array2Mean = getMean(array2);

        System.out.println(String.format(
                compareMeansOfTwoArrays(array1Mean, array2Mean),
                Arrays.toString(array1),
                Arrays.toString(array2))
        );
    }

}
