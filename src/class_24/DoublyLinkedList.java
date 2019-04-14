package class_24;

public class DoublyLinkedList extends LinkedList {
    
    public void addFirst(Node node) {
        Node temp = head;
        head = node;
        head.next = temp;
        if (count == 0)
            tail = head;
        else
            temp.prev = head;
        count++;
    }

    public void addLast(Node node) {
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        count++;
    }

    public Node removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node temp = head;
        head = head.next;
        count--;
        if (count <= 1) {
            head = tail;
        } else {
            head.prev = null;
        }
        return temp;
    }

    public Node removeLast() {
        if (isEmpty()) return null;
        Node temp = tail;
        if (count == 1) {
            head = null;
            tail = null;
        } else {
            Node prevNode = tail.prev;
            prevNode.next = null;
            tail = prevNode;
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
                    current.next.prev = previous.next;
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
