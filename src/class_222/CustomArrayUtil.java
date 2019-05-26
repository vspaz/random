package class_222;

public class CustomArrayUtil {
    static private int requiredSize = 4;

    static int getTotal(String[][][][] matrix) throws MyArrayDataException, MyArraySizeException {
        int total = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                for (int k = 0; k < matrix[i][j].length; k++) {
                    validateSize(matrix[i][j][k].length, requiredSize);
                    for (int l = 0; l < matrix[i][j][k].length; l++) {
                        try {
                            total += Integer.parseInt(matrix[i][j][k][l]);
                        } catch (NumberFormatException err) {
                            throw new MyArrayDataException(
                                    String.format("Failed to parse value from cell %d %d %d %d", i, j, k, l),
                                    err);
                        }
                    }
                }
            }
        }
        return total;
    }

    // required for the innermost array size validation; sizes of outer arrays are checked at compilation stage.
    static void validateSize(int actualSize, int requiredSize) throws MyArraySizeException {
        if (actualSize != requiredSize) {
            throw new MyArraySizeException("Wrong matrix demension; 4x4 size is required.");
        }
    }

    // some helpers to generate matrices for testing and such.
    static String[][][][] getFrouByFourMatrix() {
        String[][][][] matrix = new String[requiredSize][requiredSize][requiredSize][requiredSize];

        for (int i = 0; i < requiredSize; i++) {
            for (int j = 0; j < requiredSize; j++) {
                for (int k = 0; k < requiredSize; k++) {
                    for (int l = 0; l < requiredSize; l++) {
                        matrix[i][j][k][l] = Integer.toString(l);
                    }
                }
            }
        }

        return matrix;
    }

    static String[][][][] getSmallerSizedMatrix() {
        String[][][][] matrix = new String[requiredSize][requiredSize][requiredSize][requiredSize - 1];

        for (int i = 0; i < requiredSize; i++) {
            for (int j = 0; j < requiredSize; j++) {
                for (int k = 0; k < requiredSize; k++) {
                    for (int l = 0; l < requiredSize - 1; l++) {
                        matrix[i][j][k][l] = Integer.toString(l);
                    }
                }
            }
        }

        return matrix;
    }

    static String[][][][] getBiggerSizedMatrix() {
        String[][][][] matrix = new String[requiredSize][requiredSize][requiredSize][requiredSize + 1];

        for (int i = 0; i < requiredSize; i++) {
            for (int j = 0; j < requiredSize; j++) {
                for (int k = 0; k < requiredSize; k++) {
                    for (int l = 0; l < requiredSize + 1; l++) {
                        matrix[i][j][k][l] = Integer.toString(l);
                    }
                }
            }
        }

        return matrix;
    }
}
