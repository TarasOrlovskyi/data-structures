package orlovskyi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//import java.util.List;
//import java.util.LinkedList;

import java.util.NoSuchElementException;

class LinkedListTest extends AbstractListTest {

    @Test
    void addFirstTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addFirst(1);
        linkedList.addFirst(2);

        assertEquals(2, linkedList.size());

        assertEquals(2, linkedList.get(0));
        assertEquals(1, linkedList.get(1));
    }

    @Test
    void addLastTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addLast(1);
        linkedList.addLast(2);

        assertEquals(2, linkedList.size());

        assertEquals(1, linkedList.get(0));
        assertEquals(2, linkedList.get(1));
    }

    @Test
    void addFirstWithNullElement() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addFirst(1);
        linkedList.addFirst(null);
        linkedList.addFirst(2);

        assertEquals(3, linkedList.size());

        assertEquals(2, linkedList.get(0));
        assertNull(linkedList.get(1));
        assertEquals(1, linkedList.get(2));
    }

    @Test
    void addLastWithNullElement() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addLast(null);
        linkedList.addLast(1);

        assertEquals(2, linkedList.size());

        assertNull(linkedList.get(0));
        assertEquals(1, linkedList.get(1));
    }

    @Test
    void getFirstTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        assertEquals(3, linkedList.size());

        assertEquals(1, linkedList.getFirst());
    }

    @Test
    void getLastTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        assertEquals(3, linkedList.size());

        assertEquals(3, linkedList.getLast());
    }

    @Test
    void getFirstWithNullElementTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(null);
        linkedList.add(10);
        linkedList.add(null);
        assertEquals(3, linkedList.size());

        assertNull(linkedList.getFirst());
    }

    @Test
    void getLastWithNullElementTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(null);
        linkedList.add(10);
        linkedList.add(null);
        assertEquals(3, linkedList.size());

        assertNull(linkedList.getLast());
    }

    @Test
    void getNonexistentElementNoSuchElementException() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        assertThrows(NoSuchElementException.class, () -> {
            linkedList.getFirst();
        });

        assertThrows(NoSuchElementException.class, () -> {
            linkedList.getLast();
        });

    }

    @Override
    public <T> List<T> getList() {
        return new LinkedList<>();
    }
}