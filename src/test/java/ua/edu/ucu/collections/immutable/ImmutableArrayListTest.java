package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    ImmutableArrayList list1;
    ImmutableArrayList list2;


    @Before
    public void setUp() {
        Object[] array1 = {1, 2, true};
        Object[] array2 = {2.5, "flower"};
        list1 = new ImmutableArrayList(array1);
        list2 = new ImmutableArrayList(array2);
    }

    @Test
    public void testTestToString() {
        assertEquals("[1, 2, true]", list1.toString());
        assertEquals("[2.5, flower]", list2.toString());
    }


    @Test
    public void testAdd() {
        Object[] expected1 = {1, 2, true, false};
        Object[] actual1 = list1.add(false).toArray();
        assertArrayEquals(expected1, actual1);

        Object[] expected2 = {2.5, "flower", "boy"};
        Object[] actual2 = list2.add("boy").toArray();
        assertArrayEquals(expected2, actual2);
    }

    @Test
    public void testAddAll() {
        Object[] expected1 = {1, 2, true, false, "why"};
        Object[] actual1 = list1.addAll(new Object[]{false, "why"}).toArray();
        assertArrayEquals(expected1, actual1);

        Object[] expected2 = {2.5, "flower", "boy", -1003};
        Object[] actual2 = list2.addAll(new Object[]{"boy", -1003}).toArray();
        assertArrayEquals(expected2, actual2);
    }

    @Test
    public void testGet() {
        Object expected1 = 2;
        Object actual1 = list1.get(1);
        assertEquals(expected1, actual1);

        Object expected2 = "flower";
        Object actual2 = list2.get(1);
        assertEquals(expected2, actual2);
    }

    @Test
    public void testRemove() {
        Object[] expected1 = {2, true};
        Object[] actual1 = list1.remove(0).toArray();
        assertArrayEquals(expected1, actual1);

        Object[] expected2 = {"flower"};
        Object[] actual2 = list2.remove(0).toArray();
        assertArrayEquals(expected2, actual2);
    }

    @Test
    public void testSet() {
        Object[] expected1 = {1, "why", true};
        Object[] actual1 = list1.set(1, "why").toArray();
        assertArrayEquals(expected1, actual1);

        Object[] expected2 = {2.5, false};
        Object[] actual2 = list2.set(1, false).toArray();
        assertArrayEquals(expected2, actual2);
    }

    @Test
    public void testIndexOf() {
        Object expected1 = 1;
        Object actual1 = list1.indexOf(2);
        assertEquals(expected1, actual1);

        Object expected2 = 1;
        Object actual2 = list2.indexOf("flower");
        assertEquals(expected2, actual2);
    }

    @Test
    public void testSize() {
        Object expected1 = 3;
        Object actual1 = list1.size();
        assertEquals(expected1, actual1);

        Object expected2 = 2;
        Object actual2 = list2.size();
        assertEquals(expected2, actual2);
    }

    @Test
    public void testClear() {
        Object[] expected1 = {};
        Object[] actual1 = list1.clear().toArray();
        assertArrayEquals(expected1, actual1);

        Object[] expected2 = {};
        Object[] actual2 = list2.clear().toArray();
        assertArrayEquals(expected2, actual2);
    }

    @Test
    public void testIsEmpty() {
        boolean actual1 = list1.isEmpty();
        assertFalse(actual1);

        boolean actual2 = list2.clear().isEmpty();
        assertTrue(actual2);
    }

    @Test
    public void testToArray() {
        Object[] expected1 = {1, 2, true};
        Object[] actual1 = list1.toArray();
        assertArrayEquals(expected1, actual1);

        Object[] expected2 = {2.5, "flower"};
        Object[] actual2 = list2.toArray();
        assertArrayEquals(expected2, actual2);
    }
}
