package lists;

public class Node {
    public int value;
    public Node next;
    public Node previous = null;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
        this.previous = null;
    }

    public Node(int value, Node next, Node previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }
}
