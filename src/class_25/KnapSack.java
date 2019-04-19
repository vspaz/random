package class_25;

class KnapSack {
    static private int getMax(int a, int b) {
        if (a > b)
            return a;
        return b;
    }

    static int getTotalValue(int maxWeight, int[] weights, int[] practicalValues, int count) {
        if (count == 0 || maxWeight == 0)
            return 0;

        if (weights[count - 1] > maxWeight)
            return getTotalValue(maxWeight, weights, practicalValues, count - 1);

        else
            return getMax(
                    practicalValues[count - 1] + getTotalValue(
                            maxWeight - weights[count - 1],
                            weights,
                            practicalValues,
                            count - 1
                    ),
                    getTotalValue(maxWeight, weights, practicalValues, count - 1)
            );
    }
}
