package class_221.participants;

import java.io.*;


import org.testng.annotations.*;

import static org.testng.Assert.*;

public class MammaliaTest {
    // Mammalia is a base class for cat && human, but not robot.
    ByteArrayOutputStream byteStream;

    @Test
    public void testPrintResultFailureToJump() {
        Human human = new Human(10, 10);
        human.jump(20);
        assertEquals(byteStream.toString(), "Human can't jump 20 meter(s)\n");
        assertTrue(human.isFailed());
    }

    @Test
    public void testPrintResultAbleToJump() {
        Human human = new Human(10, 10);
        human.jump(5);
        assertEquals(byteStream.toString(), "Human can jump 5 meter(s)\n");
        assertFalse(human.isFailed());
    }

    @Test
    public void testPrintResultFailureToRun() {
        Human human = new Human(10, 10);
        human.run(20);
        assertEquals(byteStream.toString(), "Human can't run 20 meter(s)\n");
        assertTrue(human.isFailed());
    }

    @Test
    public void testPrintResultAbleToRun() {
        Human human = new Human(10, 10);
        human.run(5);
        assertEquals(byteStream.toString(), "Human can run 5 meter(s)\n");
        assertFalse(human.isFailed());
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