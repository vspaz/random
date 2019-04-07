package class_22;

import java.util.Date;

public class profResults {
    private static int size = 1_000_000; // takes quite a while to sort if the size is large.

    public static void main(String[] args) throws Exception {
        int coolDownInterval = 15_000;

        int[] nums = ArrayOps.populateRandomly(size);
        Thread.sleep(coolDownInterval);

        // timing bubble sort.
        long startTime = new Date().getTime();
        ArrayOps.bubbleSort(nums);
        printProfResults("bubble", new Date().getTime() - startTime);

        // timing selection sort.
        nums = ArrayOps.populateRandomly(size);
        Thread.sleep(coolDownInterval);

        startTime = new Date().getTime();
        ArrayOps.selectionSort(nums);
        printProfResults("selection", new Date().getTime() - startTime);

        // timing insertion sort.
        nums = ArrayOps.populateRandomly(size);
        Thread.sleep(coolDownInterval);

        startTime = new Date().getTime();
        ArrayOps.insertionSort(nums);
        printProfResults("insertion", new Date().getTime() - startTime);
    }

    static void printProfResults(String sortName, long elapsedTime) {
        System.out.println(String.format("%s sort took %d ms to sort an array of size %d.", sortName,
                elapsedTime,
                size));
    }
}
