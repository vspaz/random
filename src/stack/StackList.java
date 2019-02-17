package stack;

import lists.LinkedList;
import lists.Node;

public class StackList {
    private LinkedList list = new LinkedList();

    public void push(int item) {
        list.addFirst(new Node(item, null));
    }

    public int pop() {
        if (list.count == 0) {
            throw new RuntimeException();
        }

        int value = list.head.value;
        list.removeFirst();
        return value;
    }

    public int size() {
        return list.count;
    }

    public int peek() {
        if (list.count < 1) {
            throw new RuntimeException();
        }
        return list.head.value;
    }

    public void clear() {
        list.clear();
    }

    public void enumerate() {
        list.enumerate();
    }
}
