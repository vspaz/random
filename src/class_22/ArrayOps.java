package class_22;

import java.util.Random;

class ArrayOps {
    static private Random random = new Random();

    static void bubbleSort(int[] nums) {
        int temp;
        for (int i = nums.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    static void selectionSort(int[] nums) {
        int min, i;
        for (i = 0; i < nums.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }

    static void insertionSort(int[] nums) {
        int i, j;
        for (i = 1; i < nums.length; i++) {
            int temp = nums[i];
            j = i;
            while (j > 0 && nums[j - 1] >= temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    static int[] populateRandomly(int size) {
        assert size > 0;
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = random.nextInt(size);
        }
        return nums;
    }

    static int[] add(int[] nums, int num, int idx) {
        assert 0 <= idx && idx <= nums.length;
        int[] numsCopy = new int[nums.length + 1];
        for (int i = 0; i < idx; i++) {
            numsCopy[i] = nums[i];
        }
        numsCopy[idx] = num;
        for (int i = idx; i < nums.length; i++) {
            numsCopy[i + 1] = nums[i];
        }
        return numsCopy;
    }

    static int[] append(int[] nums, int num) {
        return add(nums, num, nums.length);
    }

    static int[] remove(int[] nums, int idx) {
        assert 0 <= idx && idx <= nums.length;
        int[] numsCopy = new int[nums.length - 1];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == idx) continue;
            numsCopy[count] = nums[i];
            count++;
        }
        return numsCopy;
    }

    static int[] pop(int[] nums) {
        return remove(nums, nums.length - 1);
    }

    static int linearSearch(int[] nums, int num) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) return i;
        }
        return -1;
    }

    // works on sorted data, only!
    static int binarySearch(int[] nums, int target) {
        int lowerBound = 0;
        int upperbound = nums.length - 1;
        int midIdx, midElement;

        while (lowerBound <= upperbound) {
            midIdx = (lowerBound + upperbound) / 2;
            midElement = nums[midIdx];
            if (midElement == target) return midIdx;
            if (midElement > target) {
                upperbound = midIdx - 1;
            } else {
                lowerBound = midIdx + 1;
            }
        }
        return -1;
    }
}
