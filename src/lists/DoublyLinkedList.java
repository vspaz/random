package lists;


public class DoublyLinkedList extends List {

    public void addFirst(Node node) {
        Node temp = head;
        head = node;
        node.next = temp;
        temp.previous = head;
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
            node.previous = tail;
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
        } else {
            head.previous = null;
        }
        return true;
    }

    public boolean removeLast() {
        if (count < 1) return false;
        if (count == 1) {
            head = null;
            tail = null;
        } else {
            tail.previous.next = null;
            tail = tail.previous;
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
                    current.next.previous = previous.next;
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
