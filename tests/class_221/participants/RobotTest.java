package class_221.participants;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.*;

// essentially same thing as Mammalia test except for the message.
public class RobotTest {

    ByteArrayOutputStream byteStream;

    @Test
    public void testPrintResultFailureToJump() {
        Robot bot = new Robot(10, 10);
        bot.jump(20);
        assertEquals(byteStream.toString(), "Robot can't jump 20 meter(s)\n");
        assertTrue(bot.isFailed());
    }

    @Test
    public void testPrintResultAbleToJump() {
        Robot bot = new Robot(10, 10);
        bot.jump(5);
        assertEquals(byteStream.toString(), "Robot can jump 5 meter(s)\n");
        assertFalse(bot.isFailed());
    }

    @Test
    public void testPrintResultFailureToRun() {
        Robot bot = new Robot(10, 10);
        bot.run(20);
        assertEquals(byteStream.toString(), "Robot can't run 20 meter(s)\n");
        assertTrue(bot.isFailed());
    }

    @Test
    public void testPrintResultAbleToRun() {
        Robot bot = new Robot(10, 10);
        bot.run(5);
        assertEquals(byteStream.toString(), "Robot can run 5 meter(s)\n");
        assertFalse(bot.isFailed());
    }

    @BeforeMethod
    public void setUp() {
        byteStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteStream));
    }

    @AfterMethod
    public void tearDown() {
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }
}