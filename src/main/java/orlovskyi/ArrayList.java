package orlovskyi;

import java.util.Objects;

public class ArrayList<T> extends AbstractList<T> {

    private static final int INITIAL_CAPACITY = 5;
    private T[] array;

    public ArrayList() {
        array = (T[]) new Object[INITIAL_CAPACITY];
    }

    public ArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    @Override
    public void add(int index, T element) {
        validateIndexForAdd(index);
        if (size == array.length) {
            T[] newArray = (T[]) new Object[(int) (array.length * 1.5 + 1)];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    @Override
    public T get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public T set(int index, T element) {
        validateIndex(index);
        T prevElement = array[index];
        array[index] = element;
        return prevElement;
    }

    @Override
    public T remove(int index) {
        validateIndex(index);
        T removedElement = array[index];
        System.arraycopy(array, index + 1, array, index, size - (index + 1));
        array[size - 1] = null;
        size--;
        return removedElement;
    }

    @Override
    public boolean remove(T element) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(array[i], element)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(array[i], element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T element) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(array[i], element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public int getCapacity() {
        return array.length;
    }
}
