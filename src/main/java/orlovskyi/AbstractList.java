package orlovskyi;

import java.util.StringJoiner;

public abstract class AbstractList<T> implements List<T> {

    //If move parameter 'size' to child class then we violate DIP of S.O.L.I.D. principles.
    //This parameter comfortably use in this class, because we avoid recurring code

    protected int size;

    public void add(T element) {
        add(size, element);
    }

    public int size() {
        return size;
    }

    public boolean contains(T element) {
        return indexOf(element) >= 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            stringJoiner.add(String.valueOf(get(i)));
        }
        return stringJoiner.toString();
    }

    protected void validateIndex(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("List is empty! There is no elements!");
        } else if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + " out of range! Index must be " +
                    "between 0 and " + (size - 1));
        }
    }

    protected void validateIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + " out of range! Index must be " +
                    "between 0 and " + size);
        }
    }
}