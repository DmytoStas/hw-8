package my.stack;

public interface BasicStack<E> {

    void push(E element);

    E remove(int index);

    void clear();

    int size();

    E peek();

    E pop();
}
