package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    ImmutableLinkedList list;

    @Before
    public void setUp() {
        Object[] array1 = {1, "flower", false};
        list = new ImmutableLinkedList(array1);
    }

    @Test
    public void testAdd() {
        Object[] expected = {1, "flower", false, -1003};
        Object[] actual = list.add(-1003).toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddAll() {
        Object[] array1 = {-1003, 2.5};
        Object[] expected = {1, "flower", -1003, 2.5, false};
        Object[] actual = list.addAll(2, array1).toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGet() {
        Object expected = "flower";
        Object actual = list.get(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemove() {
        Object[] expected = {1, false};
        Object[] actual = list.remove(1).toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSet() {
        Object[] expected = {1, "why", false};
        Object[] actual = list.set(1, "why").toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testIndexOf() {
        int expected = 1;
        int actual = list.indexOf("flower");
        assertEquals(expected, actual);
    }

    @Test
    public void testSize() {
        int expected = 3;
        int actual = list.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testClear() {
        Object[] expected = {};
        Object[] actual = list.clear().toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testIsEmpty() {
        assertFalse(list.isEmpty());
    }

    @Test
    public void testToArray() {
        Object[] expected = {1, "flower", false};
        Object[] actual = list.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddFirst() {
        Object[] expected = {2.5, 1, "flower", false};
        Object[] actual = list.addFirst(2.5).toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddLast() {
        Object[] expected = {1, "flower", false, 2.5};
        Object[] actual = list.addLast(2.5).toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGets() {
        Object expectedGetHead = 1;
        Object actualGetHead = list.getHead().getValue();
        assertEquals(expectedGetHead, actualGetHead);

        Object expectedGetTail = false;
        Object actualGetTail = list.getTail().getValue();
        assertEquals(expectedGetTail, actualGetTail);

        Object expectedGetFirst = 1;
        Object actualGetFirst = list.getFirst();
        assertEquals(expectedGetFirst, actualGetFirst);

        Object expectedGetLast = false;
        Object actualGetLast = list.getLast();
        assertEquals(expectedGetLast, actualGetLast);
    }

    @Test
    public void testRemoveFirst() {
        Object[] expected = {"flower", false};
        Object[] actual = list.removeFirst().toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveLast() {
        Object[] expected = {1, "flower"};
        Object[] actual = list.removeLast().toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToString() {
        String expected = "[1, flower, false]";
        String actual = list.toString();
        assertEquals(expected, actual);
    }
}
