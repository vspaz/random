package class_24;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SinglyLinkedListTest {
    private SinglyLinkedList createList(int size) {
        SinglyLinkedList list = new SinglyLinkedList();
        for (int i = 0; i < size; i++) {
            list.addFirst(new Node(i));
        }
        return list;
    }

    @Test
    public void testAddFirst() {
        SinglyLinkedList list = createList(5);
        assertEquals(list.head.value, 4);

        list.addFirst(new Node(10));
        assertEquals(list.head.value, 10);
    }

    @Test
    public void testAddLast() {
        SinglyLinkedList list = createList(5);
        assertEquals(list.tail.value, 0);

        list.addLast(new Node(10));
        assertEquals(list.tail.value, 10);
    }

    @Test
    public void testRemoveFirst() {
        SinglyLinkedList list = createList(5);
        assertEquals(list.removeFirst().value, 4);
        assertEquals(list.removeFirst().value, 3);
    }

    @Test
    public void testRemoveLast() {
        SinglyLinkedList list = createList(5);
        assertEquals(list.removeLast().value, 0);
        assertEquals(list.removeLast().value, 1);
    }

    @Test
    public void testRemoveAny() {
        SinglyLinkedList list = createList(1000);
        assertTrue(list.removeAny(500));
        assertFalse(list.removeAny(500000));
    }

    @Test
    public void testReverse() {
        SinglyLinkedList list = createList(10);
        assertEquals(list.head.value, 9);
        assertEquals(list.tail.value, 0);

        // desc
        assertEquals(list.head.next.value, 8);
        assertEquals(list.head.next.next.value, 7);
        assertEquals(list.head.next.next.next.value, 6);

        list.reverse();

        assertEquals(list.head.value, 0);
        assertEquals(list.tail.value, 9);

        // asc
        assertEquals(list.head.next.value, 1);
        assertEquals(list.head.next.next.value, 2);
        assertEquals(list.head.next.next.next.value, 3);
    }
}