package class_24;

public class SinglyLinkedList extends LinkedList {

    public void addFirst(Node Node) {
        Node temp = head;
        head = Node;
        Node.next = temp;
        count++;
        if (count == 1) {
            tail = Node;
        }
    }

    public void addLast(Node Node) {
        if (isEmpty()) {
            head = Node;
        } else if (count > 0) {
            tail.next = Node;
        }
        tail = Node;
        count++;
    }

    public Node removeFirst() {
        if (count < 1) {
            return null;
        }
        Node temp = head;
        head = head.next;
        count--;
        if (count <= 1) {
            head = tail;
        }
        return temp;
    }

    public Node removeLast() {
        if (isEmpty()) return null;
        Node temp = tail;
        if (count == 1) {
            head = tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        count--;
        return temp;
    }

    public boolean removeAny(int value) {
        if (isEmpty()) return false;
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

    void reverse() {
        Node prev = null;
        Node current = tail = head;
        Node nextNode;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        head = prev;
    }
}
