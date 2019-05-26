package class_222;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CustomArrayUtilTest {

    @Test
    public void testGetTotal() {
        String[][][][] nums = CustomArrayUtil.getFrouByFourMatrix();
        assertEquals(384, CustomArrayUtil.getTotal(nums));
    }

    @Test
    public void testValidateSize() {
        assertThrows(MyArraySizeException.class, () -> CustomArrayUtil.validateSize(5, 4));
    }

    @Test
    public void testMyArrayDataExceptiondOnFailureToParseInt() {
        String[][][][] nums = CustomArrayUtil.getFrouByFourMatrix();
        nums[0][0][0][0] = "foobar";
        assertThrows(MyArrayDataException.class, () -> CustomArrayUtil.getTotal(nums));
    }

    @Test
    public void testMyArraySizeExceptionRaisedWithSmallerMatrixSize() {
        String[][][][] nums = CustomArrayUtil.getSmallerSizedMatrix();
        assertThrows(MyArraySizeException.class, () -> CustomArrayUtil.getTotal(nums));
    }

    @Test
    public void testMyArraySizeExceptionRaisedWithBiggertMatrixSize() {
        String[][][][] nums = CustomArrayUtil.getBiggerSizedMatrix();
        assertThrows(MyArraySizeException.class, () -> CustomArrayUtil.getTotal(nums));
    }

}