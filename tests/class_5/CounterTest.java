package class_5;

import org.testng.annotations.Test;

import java.util.HashMap;

public class CounterTest {

    @Test
    public void testCountNum() {
        int[] nums = new int[]{1, 2, 3, 1, 2, 3, 0, 10, 1, 2, 3};

        HashMap<Integer, Integer> numToCount = Counter.countNumCount(nums);
        assert numToCount.get(1) == 3;
        assert numToCount.get(10) == 1;
    }
}