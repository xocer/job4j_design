package ru.job4j.collection;

import java.util.*;

public class SimpleHashMap<K, V> implements Iterator<V> {
    private int capacity = 16;
    private Node<K, V>[] array = new Node[capacity];
    private int size;
    private int count = 0;
    private double loadFactor = 0.75;

    public void checkSize() {
        if (capacity * loadFactor <= size) {
            array = Arrays.copyOf(array, capacity = capacity * 2);
        }
    }

    public int getIndex(K key, Node<K, V>[] array) {
        return key.hashCode() & (array.length - 1);
    }

    public boolean insert(K key, V value) {
        checkSize();
        int index = getIndex(key, array);
        if (array[index] != null) {
            return false;
        }
        array[index] = new Node(key, value);
        size++;
        return true;
    }

    V get(K key) {
        int index = getIndex(key, array);
        return array[index].value;
    }

    boolean delete(K key) {
        int index = getIndex(key, array);
        if (array[index] == null) {
            return false;
        }
        array[index] = null;
        size--;
        return true;
    }


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
