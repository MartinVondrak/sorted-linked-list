package cz.martinvondrak.sortedlinkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SortedLinkedListTest {
    @Test
    void integer() {
        SortedLinkedList<Integer> list = new SortedLinkedList<>();

        list.add(1);
        list.add(4);
        list.add(5);
        list.add(2);
        list.add(3);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
        assertEquals(5, list.get(4));

        assertFalse(list.remove(Integer.valueOf(0)));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));

        assertTrue(list.remove(Integer.valueOf(3)));
        assertEquals(4, list.remove(2));

        list.add(-5);

        assertEquals(-5, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(5, list.get(3));
    }

    @Test
    void string() {
        SortedLinkedList<String> list = new SortedLinkedList<>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("aa");
        list.add("AA");
        list.add("bc");
        list.add("bC");
        list.add("");

        assertEquals("", list.get(0));
        assertEquals("AA", list.get(1));
        assertEquals("a", list.get(2));
        assertEquals("aa", list.get(3));
        assertEquals("b", list.get(4));
        assertEquals("bC", list.get(5));
        assertEquals("bc", list.get(6));
        assertEquals("c", list.get(7));

        assertFalse(list.remove("Abč"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(10));

        assertTrue(list.remove("b"));
        assertEquals("c", list.remove(6));

        list.add("Abč");

        assertEquals("", list.get(0));
        assertEquals("AA", list.get(1));
        assertEquals("Abč", list.get(2));
        assertEquals("a", list.get(3));
        assertEquals("aa", list.get(4));
        assertEquals("bC", list.get(5));
        assertEquals("bc", list.get(6));
    }
}
