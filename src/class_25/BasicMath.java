package class_25;

public class BasicMath {
    public static double toPower(double num, double power) {
        assert power >= 0;
        if (power == 0) {
            return 1;
        } else {
            return num * toPower(num, power - 1);
        }
    }
}
