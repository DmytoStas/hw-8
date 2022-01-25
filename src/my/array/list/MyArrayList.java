package my.array.list;

import java.util.StringJoiner;

public class MyArrayList<E> implements BasicArrayList<E> {

    private Object[] values;

    private int size;

    public MyArrayList() {
        values =  new Object[0];
    }

    @Override
    public void add(E value) {
            Object[] savedArray = values;
            values =  new Object[savedArray.length + 1];
            System.arraycopy(savedArray, 0, values, 0, savedArray.length);
            values[values.length - 1] = value;
            size++;
    }

    @Override
    public E remove(int index) {
            Object[] savedArray = values;
            values =  new Object[savedArray.length - 1];
            System.arraycopy(savedArray, 0, values, 0, index);
            int numberAfterIndex = savedArray.length - index - 1;
            System.arraycopy(savedArray, index + 1, values, index, numberAfterIndex);
            size--;
            return (E) savedArray[index];
    }

    @Override
    public void clear() {
            Object[] savedArray = values;
            values = new Object[savedArray.length];
            System.out.println("Cleaning done!");
            values = null;
            size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        return (E) values[index];
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (Object item: values) {
            result.add(item.toString());
        }
        return "[" + result + "]";

    }
}
