package ru.job4j.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] array;
    private int count = 0;

    public SimpleArray(int size) {
        array = new Object[size];
    }

    public void add(T model) {
        array[count] = model;
        count++;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, count);
        array[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, count);
        System.arraycopy(array, index + 1, array, index, array.length - 1 - index);
        array[array.length - 1] = 0;
        count--;
    }

    public T get(int index) {
        Objects.checkIndex(index, count);
        return (T) array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return count < array.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[count];
            }
        };
    }
}
