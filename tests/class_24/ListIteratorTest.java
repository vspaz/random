package class_24;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ListIteratorTest {

    private ListIterator createIterator(int size) {
        DoublyLinkedList list = new DoublyLinkedList();
        for (int i = 0; i < size; i++) {
            list.addFirst(new Node(i));
        }
        return new ListIterator(list);
    }

    @Test
    public void testHasNext() {
        ListIterator list = createIterator(2);
        assertTrue(list.hasNext());

        list.next();
        assertTrue(list.hasNext());

        list.next();
        assertFalse(list.hasNext());
    }

    @Test
    public void testNext() {
        ListIterator nums = createIterator(3);
        assertTrue(nums.hasNext());

        nums.next();
        assertTrue(nums.hasNext());

        nums.next();
        assertTrue(nums.hasNext());

        nums.next();
        assertFalse(nums.hasNext());
    }

    @Test
    public void testGetCurrent() {
        ListIterator nums = createIterator(10);
        assertEquals(nums.getCurrent().value, 9);

        nums.removeCurrent();
        assertEquals(nums.getCurrent().value, 8);
    }

    @Test
    public void testRemoveCurrent() {
        ListIterator nums = createIterator(10);
        assertEquals(nums.removeCurrent().value, 9);
        assertEquals(nums.getCurrent().value, 8);
    }

    @Test
    public void testRemoveBefore() {
        ListIterator nums = createIterator(10);
        nums.next();
        nums.next();
        nums.next();
        nums.next();

        assertEquals(nums.removeBefore().value, 6);
        assertEquals(nums.removeBefore().value, 7);
        assertEquals(nums.removeBefore().value, 8);
        assertEquals(nums.removeBefore().value, 9);

        assertNull(nums.removeBefore());
        assertNull(nums.removeBefore());
    }

    @Test
    public void testRemoveAfter() {
        ListIterator nums = createIterator(6);
        assertEquals(nums.removeAfter().value, 4);
        assertEquals(nums.removeAfter().value, 3);
        assertEquals(nums.removeAfter().value, 2);
        assertEquals(nums.removeAfter().value, 1);
        assertEquals(nums.removeAfter().value, 0);

        assertNull(nums.removeAfter());
        assertNull(nums.removeAfter());
    }
}