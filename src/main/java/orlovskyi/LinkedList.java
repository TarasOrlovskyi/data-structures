package orlovskyi;

import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedList<T> extends AbstractList<T> {

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(T element) {
        add(0, element);
    }

    public void addLast(T element) {
        add(size, element);
    }

    public T getFirst() {
        validateForGetFirstAndGetLast();
        return head.element;
    }

    public T getLast() {
        validateForGetFirstAndGetLast();
        return tail.element;
    }

    @Override
    public void add(int index, T element) {
        validateIndexForAdd(index);
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else if (index == 0) {
            head.previous = newNode;
            newNode.next = head;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        } else {
            Node oldNode = getNode(index);
            newNode.next = oldNode;
            newNode.previous = oldNode.previous;
            oldNode.previous.next = newNode;
            oldNode.previous = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        validateIndex(index);
        return getNode(index).element;
    }

    @Override
    public T set(int index, T element) {
        validateIndex(index);
        Node node = getNode(index);
        T prevElement = node.element;
        node.element = element;
        return prevElement;
    }

    @Override
    public T remove(int index) {
        validateIndex(index);
        Node removedNode = getNode(index);
        removeNodeByIndex(removedNode, index);
        size--;
        return removedNode.element;
    }

    @Override
    public boolean remove(T element) {
        Node node = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(node.element, element)) {
                removeNodeByIndex(node, i);
                size--;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public int indexOf(T element) {
        Node node = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(element, node.element)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T element) {
        Node node = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(element, node.element)) {
                return i;
            }
            node = node.previous;
        }
        return -1;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private Node getNode(int index) {
        Node node;
        if (index < size / 2) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.previous;
            }
        }
        return node;
    }

    private void removeNodeByIndex(Node node, int index) {
        if (size == 1) {
            head = null;
            tail = null;
        } else if (index == 0) {
            head = head.next;
            head.previous = null;
        } else if (index == size - 1) {
            tail = tail.previous;
            tail.next = null;
        } else {
            node.next.previous = node.previous;
            node.previous.next = node.next;
        }
    }

    private void validateForGetFirstAndGetLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty! There is no element!");
        }
    }

    private class Node {
        private Node next;
        private Node previous;
        private T element;

        private Node(T element) {
            this.element = element;
        }
    }
}
