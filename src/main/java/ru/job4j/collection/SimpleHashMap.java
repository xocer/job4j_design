package ru.job4j.collection;

import java.util.*;

public class SimpleHashMap<K, V> implements Iterable<V> {

    private Node<K, V>[] array = new Node[16];
    private int size;
    private int count = 0;
    private double loadFactor = 0.75;

    public void checkSize() {
        if (array.length * loadFactor <= size) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    public int getIndex(K key) {
        return key.hashCode() & (array.length - 1);
    }

    public boolean checkKey(K key) {
        int index = getIndex(key);
        return key.equals(array[index].key);
    }

    public boolean insert(K key, V value) {
        checkSize();
        int index = getIndex(key);
        if (array[index] != null || checkKey(key)) {
            return false;
        }
        array[index] = new Node(key, value);
        size++;
        return true;
    }

    V get(K key) {
        int index = getIndex(key);
        return checkKey(key) ? array[index].value : null;
    }

    boolean delete(K key) {
        int index = getIndex(key);
        if (array[index] == null || !checkKey(key)) {
            return false;
        }
        array[index] = null;
        size--;
        return true;
    }




    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            @Override
            public boolean hasNext() {
                while (count < array.length && array[count] == null) {
                    count++;
                }
                return count < array.length;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[count++].value;
            }
        };
    }

    class Node<K, V> {
        K key;
        V value;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?, ?> node = (Node<?, ?>) o;
            return Objects.equals(key, node.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
