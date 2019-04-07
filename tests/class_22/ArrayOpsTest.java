package class_22;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayOpsTest {

    @Test
    public void testBubbleSort() {
        int[] nums = new int[]{-10, 3, 6, 8, 40, 60, 80, 90, 0, 0, 7};
        ArrayOps.bubbleSort(nums);
        assertEquals(nums, new int[]{-10, 0, 0, 3, 6, 7, 8, 40, 60, 80, 90});
    }

    @Test
    public void testSelectionSort() {
        int[] nums = new int[]{-10, 3, 6, 8, 40, 60, 80, 90, 0, 0, 7};
        ArrayOps.selectionSort(nums);
        assertEquals(nums, new int[]{-10, 0, 0, 3, 6, 7, 8, 40, 60, 80, 90});
    }

    @Test
    public void testInsertionSort() {
        int[] nums = new int[]{-10, 3, 6, 8, 40, 60, 80, 90, 0, 0, 7};
        ArrayOps.insertionSort(nums);
        assertEquals(nums, new int[]{-10, 0, 0, 3, 6, 7, 8, 40, 60, 80, 90});
    }

    @Test
    public void testAdd() {
        assertEquals(
                ArrayOps.add(new int[]{-10, 3, 6, 8, 40, 60, 80, 90, 0, 0, 7}, 100500, 5),
                new int[]{-10, 3, 6, 8, 40, 100500, 60, 80, 90, 0, 0, 7});
    }

    @Test
    public void testAppend() {
        assertEquals(
                ArrayOps.append(new int[]{-10, 3, 6, 8, 40, 60, 80, 90, 0, 0, 7}, 100500),
                new int[]{-10, 3, 6, 8, 40, 60, 80, 90, 0, 0, 7, 100500});
    }

    @Test
    public void testAddFirst() {
        assertEquals(
                ArrayOps.add(new int[]{-10, 3, 6, 8, 40, 60, 80, 90, 0, 0, 7}, 100500, 0),
                new int[]{100500, -10, 3, 6, 8, 40, 60, 80, 90, 0, 0, 7});
    }

    @Test
    public void testRemove() {
        assertEquals(
                ArrayOps.remove(new int[]{-10, 3, 6, 8, 40, 60, 80, 90, 0, 0, 7}, 4),
                new int[]{-10, 3, 6, 8, 60, 80, 90, 0, 0, 7});
    }

    @Test
    public void testPop() {
        assertEquals(
                ArrayOps.pop(new int[]{-10, 3, 6, 8, 40, 60, 80, 90, 0, 0, 7}),
                new int[]{-10, 3, 6, 8, 40, 60, 80, 90, 0, 0});
    }

    @Test
    public void removeFirst() {
        assertEquals(
                ArrayOps.remove(new int[]{-10, 3, 6, 8, 40, 60, 80, 90, 0, 0, 7}, 0),
                new int[]{3, 6, 8, 40, 60, 80, 90, 0, 0, 7});
    }

    @Test
    public void testLinearSearch() {
        assertEquals(
                ArrayOps.linearSearch(new int[]{-10, 3, 6, 8, 40, 60, 80, 90, 0, 0, 7}, 90),
                7);
    }

    @Test
    public void testLinearSearchNotFound() {
        assertEquals(
                ArrayOps.linearSearch(new int[]{-10, 3, 6, 8, 40, 60, 80, 90, 0, 0, 7}, 100500),
                -1);
    }

    @Test
    public void testBinarySearch() {
        assertEquals(
                ArrayOps.binarySearch(new int[]{-10, 0, 0, 3, 6, 7, 8, 40, 60, 80, 90}, 40),
                7);
    }

    @Test
    public void testBinarySearchNotFound() {
        assertEquals(
                ArrayOps.binarySearch(new int[]{-10, 0, 0, 3, 6, 7, 8, 40, 60, 80, 90}, 100500),
                -1);
    }
}
