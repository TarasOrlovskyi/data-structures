package orlovskyi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//import java.util.List; //comment
//import java.util.ArrayList; //comment

class ArrayListTest extends AbstractListTest {

    @Test
    void capacityTest() {
        ArrayList<Integer> integerList = new ArrayList<>();
        assertEquals(5, integerList.getCapacity());
        integerList.add(1);
        integerList.add(3);
        integerList.add(0);
        integerList.add(2, 2);
        integerList.add(4);
        integerList.add(5, 5);
        integerList.add(6);
        assertEquals(8, integerList.getCapacity());

        ArrayList<String> stringList = new ArrayList<>(1);
        stringList.add(0, "string");
        stringList.add(1, "int");
        stringList.add("boolean");
        stringList.add(1, "char");
        stringList.add(1, "date");
        stringList.add("float");
        assertEquals(7, stringList.getCapacity());
    }

    public <T> List<T> getList() {
        return new ArrayList<>();
    }
}