package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private int size;

    public int getSize() {
        return size;
    }

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        size++;
    }

    public void addFirst(T value) {
        Node<T> tmp = head;
        head = new Node<>(value, tmp);
        size++;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T result = head.value;
        Node<T> tmp = head.next;
        head.next = null;
        head = tmp;
        size--;
        return result;
    }

    public T deleteLast() {
        Node<T> tail = head;
        Node<T> tmp = tail;
        T result;

        while (tail.next != null) {
            tmp = tail;
            tail = tail.next;
        }
        tmp.next = null;
        result = tail.value;
        tail.value = null;
        size--;

        return result;
    }

    public void revert() {
        if (getSize() > 1) {
            Node<T> prev = null;
            Node<T> middle = head;
            Node<T> fol = middle.next;
            while (fol != null) {
                middle.next = prev;
                prev = middle;
                middle = fol;
                fol = middle.next;
                middle.next = prev;
            }
            head = middle;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
