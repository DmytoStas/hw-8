package my.linked.list;

import java.util.StringJoiner;

public class MyLinkedList<E> implements BasicLinkedList<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;

    public MyLinkedList() {
        lastNode = new Node<>(firstNode, null, null);
        firstNode = new Node<>(null, null, lastNode);
    }

    @Override
    public void add(E value) {
        Node<E> newContainer = lastNode;
        newContainer.setElement(value);
        lastNode = new Node<>(newContainer, null, null);
        newContainer.setNext(lastNode);
        size++;
    }

    @Override
    public void remove(int index) {
        try {
            Node<E> x = firstNode;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            moveOut(x);
        } catch (NullPointerException j) {
            System.out.println("Index out of bound!");
        }
    }

    void moveOut(Node<E> x) {
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            firstNode = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            lastNode = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.element = null;
        size--;
    }

    @Override
    public void clear() {
        for (Node<E> x = firstNode; x != null; ) {
            Node<E> next = x.next;
            x.element = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        firstNode = lastNode = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        try {
            Node<E> target = firstNode;
            for (int i = 0; i < index; i++) {
                target = checkNextElement(target);
            }
            return target.getElement();
        } catch (NullPointerException j) {
            return (E) "Out of list";
        }
    }

    private Node<E> checkNextElement(Node<E> actual) {
        return actual.getNext();
    }

    @Override
    public String toString() {
        Node<E> target = firstNode;
        StringJoiner result = new StringJoiner(", ");
            for (int i = 0; i < size; i++) {
                target = checkNextElement(target);
                result.add(target.getElement().toString());
            }
        return "[" + result + "]";
    }

    private static class Node<E> {
        E element;
        MyLinkedList.Node<E> next;
        MyLinkedList.Node<E> prev;

        public Node(MyLinkedList.Node<E> prev, E element, MyLinkedList.Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
