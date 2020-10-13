package ru.job4j.collection;

import java.util.*;

public class SimpleList<E> implements Iterable<E>{
    private int size = 0;
    private int modCount = 0;
    private Node<E> first;
    private Node<E> last;
    int count = 0;

    public void add(E value) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);

        int currentIndex = 0;
        Node<E> temp = first;

        while (temp != null) {
            if (currentIndex == index) {
                return temp.element;
            }
            temp = temp.next;
            currentIndex++;
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return count < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) get(count++);
            }
        };
    }


    public class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}



