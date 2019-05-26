package class_221;


import java.util.Random;

class Obstacle {
    int value;
    Random random = new Random();

    Obstacle(int range) {
        value = random.nextInt(range);
    }

    int getValue() {
        return value;
    }
}
