package my.hashmap;

import java.util.Objects;

public class MyHashMap<K, V> implements BasicHashMap<K, V> {

    private final static int TABLE_CAPACITY = 16;

    private final Node<K, V>[] table = new Node[TABLE_CAPACITY];

    private int size = 0;

    int hash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static int indexFor(int hash, int length) {
        return (length - 1) & hash;
    }

    @Override
    public void put(K key, V value) {

        int index = indexFor(hash(key), table.length);

        Node<K, V> newNode = new Node<>(hash(key), key, value, null);

        Node<K, V> p;

        //Якщо комірка пуста, просто додається нова Нода
        if ((p = table[index]) == null) {
            table[index] = newNode;
            size++;
        }
        // Якщо комірка не пуста порівнюємо ключі по хешу
        //якщо вони однакові, то перезаписуємо стару Ноду новою
        //Якщо ні, то записуємо нову Ноду. При цьому prevNode.next = newNode
        else {
            K k;
            if (p.hash == hash(key) && ((k = p.key) == key || (key != null && key.equals(k)))) {
                p.setValue(newNode.value);
            } else {
                while (p.next != null) {
                    p = p.next;
                }
                p.next = newNode;
                size++;

            }
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
            size = 0;
        }
    }

    @Override
    public void remove(K key) {
        int index = indexFor(hash(key), table.length);
        Node<K, V> rNode;

        //Перевіряємо чи є в масиві обєкт із необхідним ключем
        if ((rNode = table[index]) != null) {
            //Перевіряємо першу Ноду, чи є в неї посилання на наступні Ноди
            //Якщо немає видаляємо комірку
            if (rNode.next == null) {
                table[index] = null;
                size--;
                //Якщо нода в комірці не одна, то знайди і видалити по ключу
            } else {
                while (rNode.next != null) {
                    if (hash(rNode.getKey()) == hash(key)) {
                        continue;
                    }
                    table[index] = rNode.next;
                }
                size--;
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public V get(K key) {
        int index = indexFor(hash(key), table.length);
        Node<K, V> gNode;
        V result = null;
        //Перевіряємо чи є в масиві обєкт із необхідним ключем
        if ((gNode = table[index]) != null) {
            //Перевіряємо першу Ноду, чи є в неї посилання на наступні Ноди
            //Якщо немає виводимо
            if (gNode.next == null) {
                result = gNode.value;
                //Якщо нода в комірці не одна, то знайди і виведи по ключу
            } else {
                while (gNode.next != null) {
                    if (hash(gNode.key) == hash(key)) {
                        result = gNode.getValue();
                    }
                }
            }
        }
        return result;
    }


    private class Node<K, V> {
        private final int hash;
        private final K key;
        private V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final String toString() {
            return key + "=" + value;
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
                if (Objects.equals(key, objectNode.getKey()) &&
                        Objects.equals(value, objectNode.getValue())) {
                    //Якщо так, то повернеться true
                    return true;
                }
            }
            //Якщо жодна перевірка не пройшла, то повернеться false
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
    }
}