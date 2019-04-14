package class_24;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DoublyLinkedListTest {
    private DoublyLinkedList createList(int size) {
        DoublyLinkedList list = new DoublyLinkedList();
        for (int i = 0; i < size; i++) {
            list.addFirst(new Node(i));
        }
        return list;
    }

    @Test
    public void testAddFirst() {
        DoublyLinkedList list = createList(5);
        assertEquals(list.head.value, 4);

        list.addFirst(new Node(1000));
        assertEquals(list.head.value, 1000);
    }

    @Test
    public void testAddLast() {
        DoublyLinkedList list = createList(5);
        assertEquals(list.tail.value, 0);
        assertEquals(list.count, 5);

        list.addLast(new Node(1000));
        assertEquals(list.tail.value, 1000);
    }

    @Test
    public void testRemoveFirst() {
        DoublyLinkedList list = createList(5);
        assertEquals(list.removeFirst().value, 4);
        assertEquals(list.head.value, 3);
    }

    @Test
    public void testRemoveLast() {
        DoublyLinkedList list = createList(5);
        assertEquals(list.removeLast().value, 0);
        assertEquals(list.tail.value, 1);
    }

    @Test
    public void testRemoveAny() {
        DoublyLinkedList list = createList(10);
        assertTrue(list.removeAny(9));
        assertFalse(list.removeAny(1000));
    }

    @Test
    public void testContains() {
        DoublyLinkedList list = createList(10);
        assertTrue(list.contains(5));
        assertFalse(list.contains(100000000));
    }

    @Test
    public void testClear() {
        DoublyLinkedList list = createList(10);
        assertTrue(list.contains(5));
        list.clear();
        assertEquals(list.count, 0);
    }
}