package class_221.participants;

public class Human extends Mammalia {
    public Human(int runDistance, int jumpHeight) {
        super(runDistance, jumpHeight);
    }

    public void feed() {
        System.out.println("has to feed the cat");
    }

    public String toString() {
        return "Human";
    }
}

