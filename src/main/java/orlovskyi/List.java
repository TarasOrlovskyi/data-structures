package orlovskyi;

interface List<T> {
    void add(int index, T element);

    void add(T element);

    int size();

    boolean isEmpty();

    T get(int index);

    T set(int index, T element);

    T remove(int index);

    boolean remove(T element);

    boolean contains(T element);

    int indexOf(T element);

    int lastIndexOf(T element);

    void clear();

    String toString();
}