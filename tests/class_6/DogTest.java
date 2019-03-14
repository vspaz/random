package class_6;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DogTest {

    @Test
    public void testSetSwimAbility() {
        Dog dog = new Dog("Alba");
        dog.setSwimAbility(10);
        assertEquals(dog.swim(10), "Alba swim 10.00 meters. weeeeee!!!!");

        dog.setSwimAbility(5);
        assertEquals(dog.swim(10), "Alba can't swim 10.00 meters. :-(");
    }
}