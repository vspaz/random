package class_6;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AnimalTest {

    private Animal getBeast() {
        class Beast extends Animal {
            private Beast(String name) {
                super(name);
            }
        }
        return new Beast("Beast");
    }

    @Test
    public void testSetJumpHeight() {
        Animal beast = getBeast();
        beast.setJumpHeight(10);
        assertEquals(beast.jump(10), "Beast jump 10.00 meters. weeeeee!!!!");

        beast.setJumpHeight(5);
        assertEquals(beast.jump(10), "Beast can't jump 10.00 meters. :-(");
    }

    @Test
    public void testSetRunDistance() {
        Animal beast = getBeast();
        beast.setRunDistance(200);
        assertEquals(beast.run(199), "Beast run 199.00 meters. weeeeee!!!!");

        beast.setRunDistance(198);
        assertEquals(beast.run(199), "Beast can't run 199.00 meters. :-(");
    }

    @Test
    public void testGetAbility() {
        Animal beast = getBeast();
        beast.setJumpHeight(10);
        assertEquals(
                beast.getAbility(10, 5, "crawl"),
                "Beast crawl 5.00 meters. weeeeee!!!!");
    }
}