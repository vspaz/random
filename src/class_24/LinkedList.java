package class_24;

public abstract class LinkedList {
    Node head;
    Node tail;
    public int count = 0;

    boolean isEmpty() {
        return count == 0;
    }

    boolean contains(int value) {
        if (isEmpty()) {
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

    void clear() {
        head = null;
        tail = null;
        count = 0;
    }
}
