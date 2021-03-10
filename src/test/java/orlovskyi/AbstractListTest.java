package orlovskyi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//import java.util.List; //comment

public abstract class AbstractListTest {
    private List<String> list = getList();

    @Test
    void addWithIndexFirstLastAndMiddleElementTest() {
        list.add("green");
        list.add("white");
        list.add("yellow");
        list.add("white");
        list.add("black");

        list.add(0, "First");
        list.add(3, "Middle");
        list.add(7, "Last");
        assertEquals(8, list.size());
        assertEquals("First", list.get(0));
        assertEquals("Middle", list.get(3));
        assertEquals("Last", list.get(7));
    }

    @Test
    void addWithoutIndexTest() {
        list.add("green");
        list.add("white");
        list.add("yellow");

        list.add("Last");
        assertEquals(4, list.size());
        assertEquals("Last", list.get(3));
    }

    @Test
    void addOutOfListItemIndexOutOfBoundsExceptionTest() {
        list.add("green");
        list.add("white");
        list.add("yellow");
        assertEquals(3, list.size());

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(-10, "-10");
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(20, "20");
        });
    }

    @Test
    void addFirstElementByIndexInClearListTest() {

        list.add(0, "1");
        assertEquals(1, list.size());
        assertEquals("1", list.get(0));
    }

    @Test
    void addNullElementTest() {
        list.add("1");
        list.add(null);
        list.add(1, null);
        list.add("4");
        list.add(4, null);

        assertEquals(5, list.size());

        assertEquals("1", list.get(0));
        assertNull(list.get(1));
        assertNull(list.get(2));
        assertEquals("4", list.get(3));
        assertNull(list.get(4));
    }

    @Test
    void removeUnreachableElementIndexOutOfBoundsExceptionTest() {
        list.add("green");
        list.add("white");
        list.add("yellow");
        assertEquals(3, list.size());

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(5);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(13);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(-10);
        });

        list.clear();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(0);
        });
    }

    @Test
    void removeNullElementByIndexTest() {
        list.add("1");
        list.add(null);
        list.add("2");
        assertNull(list.remove(1));
        assertEquals(2, list.size());
    }

    @Test
    void removeFirstLastAndMiddleByIndexTest() {
        list.add("green");
        list.add("white");
        list.add("yellow");
        list.add("white");
        list.add("black");
        assertEquals(5, list.size());

        assertEquals("green", list.remove(0));
        assertEquals("black", list.remove(3));
        assertEquals("yellow", list.remove(1));

        assertEquals(2, list.size());

        assertEquals("white", list.remove(0));
        assertEquals("white", list.remove(0));

        assertEquals(0, list.size());
    }

    @Test
    void removeNonexistentElementByElementTest() {
        list.add("green");
        list.add("white");
        list.add("yellow");
        assertEquals(3, list.size());
        assertFalse(list.remove("red"));
    }

    @Test
    void removeNullElementTest() {
        list.add(null);
        list.add("hello");
        assertEquals(2, list.size());
        assertTrue(list.remove(null));
        assertEquals(1, list.size());
    }

    @Test
    void removeFirstLastAndMiddleElementByElementTest() {
        list.add("green");
        list.add("white");
        list.add("yellow");
        list.add("white");
        list.add("black");
        assertEquals(5, list.size());

        assertTrue(list.remove("green"));
        assertTrue(list.remove("black"));
        assertTrue(list.remove("yellow"));

        assertEquals(2, list.size());
    }

    @Test
    void getUnreachableElementIndexOutOfBoundsExceptionTest() {
        list.add("green");
        list.add("white");
        list.add("yellow");
        assertEquals(3, list.size());

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(10);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(-10);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(5);
        });

        list.clear();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(0);
        });
    }

    @Test
    void getElementByIndexTest() {
        list.add("green");
        list.add("white");
        list.add("yellow");

        assertEquals("green", list.get(0));
        assertEquals("white", list.get(1));
        assertEquals("yellow", list.get(2));
    }

    @Test
    void getNullElementTest() {
        list.add(null);
        list.add("second");
        assertNull(list.get(0));
    }

    @Test
    void setUnreachableElementIndexOutOfBoundsExceptionTest() {
        list.add("green");
        list.add("white");
        list.add("yellow");
        assertEquals(3, list.size());

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set(-2, "-2");
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set(100, "100");
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set(5, "5");
        });

        list.clear();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set(0, "red");
        });
    }

    @Test
    void setListWithOneElementTest() {
        list.add("first");
        assertEquals("first", list.set(0, "replacement"));
        assertEquals("replacement", list.get(0));
    }

    @Test
    void setFirstLastAndMiddleElementTest() {
        list.add("green");
        list.add("white");
        list.add("yellow");
        assertEquals(3, list.size());

        assertEquals("green", list.set(0, "red"));
        assertEquals("red", list.get(0));

        assertEquals("white", list.set(1, "brown"));
        assertEquals("brown", list.get(1));

        assertEquals("yellow", list.set(2, "pink"));
        assertEquals("pink", list.get(2));

        assertEquals(3, list.size());
    }

    @Test
    void setNullElementTest() {
        list.add("First");
        list.add(null);
        list.add("Last");

        assertNull(list.set(1, "value"));
        assertEquals("value", list.get(1));
    }

    @Test
    void indexOfWithExistAndNonexistentElementTest() {
        list.add("green");
        list.add("white");
        list.add("yellow");
        list.add("white");
        list.add("black");

        assertEquals(-1, list.indexOf("red"));

        assertEquals(0, list.indexOf("green"));
        assertEquals(1, list.indexOf("white"));
        assertEquals(2, list.indexOf("yellow"));
        assertEquals(4, list.indexOf("black"));

    }

    @Test
    void lastIndexOfWithExistAndNonexistentElementTest() {
        list.add("green");
        list.add("white");
        list.add("yellow");
        list.add("white");
        list.add("black");

        assertEquals(-1, list.lastIndexOf("brown"));

        assertEquals(0, list.lastIndexOf("green"));
        assertEquals(3, list.lastIndexOf("white"));
        assertEquals(2, list.lastIndexOf("yellow"));
        assertEquals(4, list.lastIndexOf("black"));
    }

    @Test
    void indexOfWithNullElementTest() {
        list.add("green");
        list.add(null);
        list.add("yellow");
        list.add(null);
        list.add("black");

        assertEquals(1, list.indexOf(null));

    }

    @Test
    void lastIndexOfWithNullElementTest() {
        list.add("green");
        list.add(null);
        list.add("yellow");
        list.add(null);
        list.add("black");

        assertEquals(3, list.lastIndexOf(null));
    }

    @Test
    void containsTest() {
        list.add("green");
        list.add("white");
        list.add("yellow");

        assertFalse(list.contains("pink"));
        assertTrue(list.contains("white"));
    }

    @Test
    void containsNullElementTest() {
        list.add(null);
        list.add("element");
        list.add(null);
        list.add("last");
        assertTrue(list.contains(null));
    }

    @Test
    void clearTest() {
        list.add("green");
        list.add(null);
        list.add("yellow");
        assertEquals(3, list.size());

        list.clear();

        assertEquals(0, list.size());
    }

    @Test
    void isEmptyTest() {
        list.add("green");
        list.add(null);
        list.add("yellow");
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void sizeTest() {
        list.add("green");
        list.add(null);
        list.add("yellow");
        assertEquals(3, list.size());
        list.add("brown");
        assertEquals(4, list.size());
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void toStringTest() {
        list.add("green");
        list.add(null);
        list.add("yellow");
        assertEquals("[green, null, yellow]", list.toString());
        list.remove(0);
        assertEquals("[null, yellow]", list.toString());
        list.add("red");
        assertEquals("[null, yellow, red]", list.toString());
        list.clear();
        assertEquals("[]", list.toString());
        list.add("first");
        assertEquals("[first]", list.toString());
    }

    public abstract <T> List<T> getList();
}