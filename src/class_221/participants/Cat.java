package class_221.participants;

public class Cat extends Mammalia {
    public Cat(int distance, int height) {
        super(distance, height);
    }

    public void sleep() {
        System.out.println("sleeps 20 hours a day.");
    }

    public String toString() {
        return "Cat";
    }
}
