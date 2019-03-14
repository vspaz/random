package class_6;

public class Pets {
    public static void main(String[] args) {
        Cat cat = new Cat("Snooty");
        System.out.println(cat.run(100));
        System.out.println(cat.run(500));

        System.out.println(cat.jump(1));
        System.out.println(cat.jump(10));

        Dog dog = new Dog("Alba");
        System.out.println(dog.run(300));
        System.out.println(dog.run(1000));

        System.out.println(dog.jump(0.4));
        System.out.println(dog.jump(2));

        System.out.println(dog.swim(5));
        System.out.println(dog.swim(100));
    }
}
