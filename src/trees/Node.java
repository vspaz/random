package trees;

public class Node {
    public int id;
    public double data;
    public Node left;
    public Node right;

    public Node(int id, double data) {
        this.id = id;
        this.data = data;
    }

    public void displayNode() {
        System.out.print(String.format("%s %s", id, data));
    }
}


