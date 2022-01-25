package my.queue;

import java.util.StringJoiner;

public class MyQueue<E> implements BasicQueue<E> {

    private Object[] elements;

    private int size;

    public MyQueue() {
        try {
            elements =  new Object[0];
        } catch (ClassCastException j) {
            System.out.println("Object is not an instance of a class");
        }
    }

    @Override
    public void add(E element) {
            Object[] savedArray = elements;
            elements = new Object[savedArray.length + 1];
            System.arraycopy(savedArray, 0, elements, 0, savedArray.length);
            elements[elements.length - 1] = element;
    }

    @Override
    public E remove(int index) {
            Object[] savedArray = elements;
            elements = new Object[savedArray.length - 1];
            System.arraycopy(savedArray, 0, elements, 0, index);
            int numberAfterIndex = savedArray.length - index - 1;
            System.arraycopy(savedArray, index + 1, elements, index, numberAfterIndex);
            return (E) savedArray[index];
    }

    @Override
    public void clear() {
            Object[] savedArray = elements;
            elements = new Object[savedArray.length];
            System.out.println("Cleaning done!");
            elements = null;
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public E peek() {
        return (E) elements[0];
    }

    @Override
    public E poll() {
        Object[] savedArray;
            savedArray = elements;
            elements = new Object[savedArray.length - 1];
            System.arraycopy(savedArray, 1, elements, 0, savedArray.length - 1);
        return (E) savedArray[0];
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (Object item: elements) {
            result.add(item.toString());
        }
        return "" + result + "";

    }
}
