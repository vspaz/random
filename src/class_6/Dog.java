package class_6;

public class Dog extends Animal {
    private double swimAbility;

    public Dog(String name) {
        super(name);
        // default values for Dog instance.
        this.setJumpHeight(0.5);
        this.setRunDistance(500);
        this.setSwimAbility(10);
    }

    void setSwimAbility(double distance) {
        swimAbility = distance;
    }

    String swim(double distance) {
        return getAbility(swimAbility, distance, "swim");
    }
}
