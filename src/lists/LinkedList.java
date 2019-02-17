package lists;


public class LinkedList extends List {

    public void addFirst(Node node) {
        Node temp = head;
        head = node;
        node.next = temp;
        count++;
        if (count == 1) {
            tail = node;
        }
    }

    public void addLast(Node node) {
        if (count == 0) {
            head = node;
        } else if (count > 0) {
            tail.next = node;
        }
        tail = node;
        count++;
    }

    public boolean removeFirst() {
        if (count < 1) {
            return false;
        }
        head = head.next;
        count--;
        if (count <= 1) {
            head = tail;
        }
        return true;
    }

    public boolean removeLast() {
        if (count < 1) return false;
        if (count == 1) {
            head = null;
            tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        count--;
        return true;
    }

    public boolean removeAny(int value) {
        if (count < 1) return false;
        Node previous = null;
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                if (previous != null) {
                    previous.next = current.next;
                } else {
                    removeFirst();
                }
                count--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }
}