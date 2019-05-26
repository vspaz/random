package class_221;

import org.testng.annotations.Test;

public class ObstacleTest {

    @Test
    public void testGetValue() {
        Obstacle obstacle = new Obstacle(10);
        assert 0 <= obstacle.getValue() && obstacle.getValue() <= 10;
    }
}