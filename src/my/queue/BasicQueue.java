package my.queue;

public interface BasicQueue<E> {

    void add(E element);

    E remove(int index);

    void clear();

    int size();

    E peek();

    E poll();
}
