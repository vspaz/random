import trees.*;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(50, 15.5);
        tree.insert(25, 1.7);
        tree.insert(75, 1.9);
        System.out.println(tree.contains(25).data);
    }
}
