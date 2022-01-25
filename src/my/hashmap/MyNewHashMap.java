package my.hashmap;

import java.util.Objects;

public class MyNewHashMap<K, V> implements BasicHashMap<K, V>{

    private int size = 0;



    static class Node<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final String toString() {
            return key + "=" + value;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        @Override
        public boolean equals(Object o) {
            //Якщо посилання на обєкт та переданий обєкт еквівалентні, то повернеться true
            if (this == o) {
                return true;
            }

            //Якщо перша преревірка не пройшла, то
            //Якщо обєкт являється обєктом класу Node, виконуємо логіку
            if (o instanceof Node) {
                //Створюємо цей обєкт і явно приводимо його до Node
                Node<K, V> objectNode = (Node) o;

                //Перевіряємо чи:
                //1.key з поля класу еквівалентний key - objectNode;
                //and
                //2.value з поля класу еквівалентний value - objectNode;
                //or
                //3.hash з поля класу еквівалентний hash - objectNode;
                if (Objects.equals(key, objectNode.getKey()) &&
                        Objects.equals(value, objectNode.getValue()) ||
                        Objects.equals(hash, objectNode.hashCode())) {
                    //Якщо так, то повернеться true
                    return true;
                }
            }
            //Якщо жодна перевірка не пройшла, то повернеться false
            return false;
        }
    }
    @Override
    public void put(K key, V value) {

    }

    @Override
    public void remove(K key) {

    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public V get(K key) {
        return null;
    }
}
