package orlovskyi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import java.util.List; //comment

public abstract class AbstractListTest {
    private List<String> list = getList();

    @BeforeEach
    void before() {
        list.add("green");
        list.add("white");
        list.add("yellow");
        list.add("white");
        list.add("black");
    }

    @Test
    void addTest() {
        assertEquals(5, list.size());
        list.add("8");
        list.add(1, "2");
        list.add(4, "5");
        list.add(0, "0");
        list.add("9");
        list.add(10, "10");
        assertEquals(11, list.size());
        assertEquals("0", list.get(0));
        assertEquals("green", list.get(1));
        assertEquals("2", list.get(2));
        assertEquals("white", list.get(3));
        assertEquals("yellow", list.get(4));
        assertEquals("5", list.get(5));
        assertEquals("white", list.get(6));
        assertEquals("black", list.get(7));
        assertEquals("8", list.get(8));
        assertEquals("9", list.get(9));
        assertEquals("10", list.get(10));

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(-10, "-10");
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(20, "20");
        });

        list.clear();

        list.add(0, "1");
        assertEquals(1, list.size());
        assertEquals("1", list.get(0));
        list.clear();

        list.add("1");
        list.add(1, "2");
        assertEquals(2, list.size());
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        list.clear();

        list.add("1");
        list.add(0, "0");
        list.add(2, "2");
        assertEquals(3, list.size());
        assertEquals("0", list.get(0));
        assertEquals("1", list.get(1));
        assertEquals("2", list.get(2));
        list.clear();

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
        list.clear();
    }

    @Test
    void removeByIndexTest() {
        assertEquals(5, list.size());

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(5);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(13);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(-10);
        });

        assertEquals("black", list.remove(4));
        assertEquals("green", list.remove(0));
        assertEquals("white", list.remove(2));

        assertEquals("white", list.get(0));
        assertEquals("yellow", list.get(1));

        assertEquals(2, list.size());

        assertEquals("white", list.remove(0));
        assertEquals("yellow", list.remove(0));

        assertEquals(0, list.size());

        list.add("first");
        assertEquals(1, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(1);
        });
        assertEquals("first", list.remove(0));
        assertEquals(0, list.size());

        list.add("1");
        list.add(null);
        list.add("2");
        assertNull(list.remove(1));
        assertEquals(2, list.size());

        list.clear();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(0);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(1);
        });
    }

    @Test
    void removeByElementTest() {
        assertEquals(5, list.size());
        assertTrue(list.remove("green"));
        assertTrue(list.remove("black"));
        assertTrue(list.remove("yellow"));
        assertFalse(list.remove("red"));
        assertEquals(2, list.size());

        assertEquals("white", list.get(0));
        assertEquals("white", list.get(1));

        assertTrue(list.remove("white"));
        assertTrue(list.remove("white"));
        assertEquals(0, list.size());

        assertFalse(list.remove("white"));

        list.add(null);
        list.add("hello");
        assertEquals(2, list.size());
        assertTrue(list.remove(null));
        assertEquals(1, list.size());
    }

    @Test
    void getTest() {
        assertEquals("green", list.get(0));
        assertEquals("white", list.get(1));
        assertEquals("yellow", list.get(2));
        assertEquals("black", list.get(4));

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
        assertEquals(0, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(0);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(1);
        });

        list.add("first");
        assertEquals("first", list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(1);
        });
        list.add(null);
        list.add("second");
        assertNull(list.get(1));
    }

    @Test
    void setTest() {
        assertEquals(5, list.size());
        assertEquals("green", list.set(0, "red"));
        assertEquals("red", list.get(0));
        assertEquals("yellow", list.set(2, "brown"));
        assertEquals("brown", list.get(2));
        assertEquals("black", list.set(4, "pink"));
        assertEquals("pink", list.get(4));
        assertEquals(5, list.size());

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
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set(1, "red");
        });

        list.add("first");
        assertEquals("first", list.get(0));
        assertEquals("first", list.set(0, "replacement"));
        assertEquals("replacement", list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set(1, "red");
        });
        list.add(null);
        list.add("parameter");
        assertEquals(3, list.size());
        assertNull(list.set(1, "value"));
    }

    @Test
    void indexOfTest() {

        assertEquals(-1, list.indexOf("red"));
        assertEquals(-1, list.lastIndexOf("brown"));

        assertEquals(1, list.indexOf("white"));
        assertEquals(2, list.indexOf("yellow"));
        assertEquals(3, list.lastIndexOf("white"));
        list.set(1, null);
        list.set(3, null);
        assertEquals(1, list.indexOf(null));
        assertEquals(3, list.lastIndexOf(null));

        list.add("last");
        list.add(0, "first");
        assertEquals(6, list.indexOf("last"));
        assertEquals(0, list.indexOf("first"));
        assertEquals(6, list.lastIndexOf("last"));
        assertEquals(0, list.lastIndexOf("first"));
    }

    @Test
    void containsTest() {
        assertFalse(list.contains("pink"));
        list.add("pink");
        assertTrue(list.contains("pink"));
        assertTrue(list.contains("black"));
        list.clear();

        list.add(null);
        list.add("element");
        list.add(null);
        list.add(3, "last");
        assertTrue(list.contains(null));
        assertEquals(4, list.size());
    }

    @Test
    void clearTest() {
        assertEquals(5, list.size());
        assertEquals("green", list.get(0));

        list.clear();

        assertEquals(0, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(0);
        });
    }

    @Test
    void isEmptyTest() {
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(0);
        });
    }

    @Test
    void sizeTest() {
        assertEquals(5, list.size());
        list.add("brown");
        assertEquals(6, list.size());
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void toStringTest() {
        assertEquals("[green, white, yellow, white, black]", list.toString());
        list.remove(0);
        assertEquals("[white, yellow, white, black]", list.toString());
        list.add("red");
        assertEquals("[white, yellow, white, black, red]", list.toString());
        list.set(2, null);
        assertEquals("[white, yellow, null, black, red]", list.toString());
        list.clear();
        assertEquals("[]", list.toString());
        list.add("first");
        assertEquals("[first]", list.toString());
    }

    public abstract <T> List<T> getList();
}