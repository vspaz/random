package class_222;

public class TestExceptions {
    public static void main(String[] args) {
        System.out.println(CustomArrayUtil.getTotal(CustomArrayUtil.getFrouByFourMatrix()));
        try {

            CustomArrayUtil.getTotal(CustomArrayUtil.getSmallerSizedMatrix());
        } catch (MyArraySizeException err) {
            System.out.println(err.getMessage());
        }

        try {
            CustomArrayUtil.getTotal(CustomArrayUtil.getBiggerSizedMatrix());
        } catch (MyArraySizeException err) {
            System.out.println(err.getMessage());
        }

        String[][][][] nums = CustomArrayUtil.getFrouByFourMatrix();
        nums[0][0][0][3] = "junkvalue";
        try {
            CustomArrayUtil.getTotal(nums);
        } catch (MyArrayDataException err) {
            System.out.println(err.getMessage());
        }

        // MyArraySizeException is not caught as MyArrayDataException is thrown.
        try {
            CustomArrayUtil.getTotal(nums);
        } catch (MyArraySizeException err) {
            System.out.println(err.getMessage());
        }
    }
}
