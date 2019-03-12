package class_5;

import java.util.HashMap;

public class Counter {

    public static HashMap<Integer, Integer> countNumCount(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();

        for (int num : nums) {
            if (counter.containsKey(num)) {
                counter.put(num, counter.get(num) + 1);
            } else {
                counter.put(num, 1);
            }
        }
        return counter;
    }
}
