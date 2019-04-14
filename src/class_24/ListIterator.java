package class_24;


import java.util.Iterator;

public class ListIterator implements Iterator {
    private DoublyLinkedList list;
    private Node current;

    ListIterator(DoublyLinkedList list) {
        this.list = list;
        current = list.head;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Node next() {
        current = current.next;
        return current;
    }

    Node getCurrent() {
        return current;
    }

    Node removeCurrent() {
        if (list.count == 0 || !hasNext()) {
            return null;
        }
        if (list.count == 1) {
            return list.removeFirst();
        }
        Node temp = current;
        if (current == list.head) {
            list.removeFirst();
        } else if (current == list.tail) {
            list.removeLast();
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        current = next();
        return temp;
    }

    Node removeBefore() {
        if (list.count == 0 || !hasNext()|| current == list.head) {
            return null;
        }
        if (current.prev == list.head) {
            return list.removeFirst();

        } else {
            Node temp = current.prev;
            current.prev = current.prev.prev;
            current.prev.next = current;
            return temp;
        }
    }

    Node removeAfter() {
        if (list.count == 0 || !hasNext() || current == list.tail) {
            return null;
        }
        if (current.next == list.tail) {
            return list.removeLast();
        } else {
            Node temp = current.next;
            current.next = current.next.next;
            current.next.prev = current;
            return temp;
        }
    }
}
