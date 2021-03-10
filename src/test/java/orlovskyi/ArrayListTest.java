package orlovskyi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//import java.util.List; //comment
//import java.util.ArrayList; //comment

class ArrayListTest extends AbstractListTest {

    @Test
    void setCapacityTest() {
        ArrayList<String> stringList = new ArrayList<>(1);
        stringList.add("string");
        stringList.add("int");
        stringList.add("boolean");
        stringList.add("char");
        stringList.add("date");
        stringList.add("float");
        assertEquals(7, stringList.getCapacity());
    }

    @Test
    void defaultCapacityTest() {
        ArrayList<Integer> integerList = new ArrayList<>();
        assertEquals(5, integerList.getCapacity());
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        integerList.add(6);
        integerList.add(7);
        assertEquals(8, integerList.getCapacity());
    }

    public <T> List<T> getList() {
        return new ArrayList<>();
    }
}