package class_6;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
        // default values for Cat instance;
        this.setRunDistance(200);
        this.setJumpHeight(2);
    }
}
