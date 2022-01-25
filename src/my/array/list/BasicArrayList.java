package my.array.list;

public interface BasicArrayList<E> {
    void add(E value);

    E remove(int index);

    void clear();

    int size();

    E get(int index);
}
