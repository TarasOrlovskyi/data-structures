package orlovskyi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//import java.util.List;
//import java.util.LinkedList;

import java.util.NoSuchElementException;

class LinkedListTest extends AbstractListTest {

    @Test
    void addFirstAndAddLast() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        linkedList.addLast(3);
        linkedList.addLast(4);
        assertEquals(9, linkedList.size());

        assertEquals(1, linkedList.get(0));
        assertEquals(2, linkedList.get(1));
        assertEquals(3, linkedList.get(7));
        assertEquals(4, linkedList.get(8));

        linkedList.clear();
        linkedList.addFirst(null);
        assertEquals(1, linkedList.size());
        assertNull(linkedList.get(0));

        linkedList.clear();
        linkedList.addLast(null);
        linkedList.addFirst(1);
        linkedList.addFirst(null);
        assertEquals(3, linkedList.size());
        assertNull(linkedList.get(0));
        assertNull(linkedList.get(2));

        linkedList.clear();
        linkedList.addFirst(1);
        assertEquals(1, linkedList.size());
        assertEquals(1, linkedList.get(0));

        linkedList.clear();
        linkedList.addLast(1);
        assertEquals(1, linkedList.size());
        assertEquals(1, linkedList.get(0));
    }

    @Test
    void getFirstAndGetLast() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        assertThrows(NoSuchElementException.class, () -> {
            linkedList.getFirst();
        });

        assertThrows(NoSuchElementException.class, () -> {
            linkedList.getLast();
        });

        linkedList.add(10);
        assertEquals(1, linkedList.size());
        assertEquals(10, linkedList.getFirst());
        assertEquals(10, linkedList.getLast());
        linkedList.clear();

        linkedList.add(null);
        linkedList.add(10);
        linkedList.add(null);
        assertEquals(3, linkedList.size());
        assertNull(linkedList.getFirst());
        assertNull(linkedList.getLast());
        linkedList.clear();

        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);
        assertEquals(5, linkedList.size());
        assertEquals(10, linkedList.getFirst());
        assertEquals(50, linkedList.getLast());
    }

    @Override
    public <T> List<T> getList() {
        return new LinkedList<>();
    }
}