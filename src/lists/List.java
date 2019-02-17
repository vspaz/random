package lists;

public abstract class List implements LinkList {
    public Node head;
    public Node tail;
    public int count = 0;

    public boolean contains(int value) {
        if (count < 1) {
            return false;
        }
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void enumerate() {
        Node current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }
}
