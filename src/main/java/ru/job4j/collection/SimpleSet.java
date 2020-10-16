package ru.job4j.collection;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    SimpleArray<T> simpleArray = new SimpleArray<>();

    public boolean add(T model) {
        for (int i = 0; i < simpleArray.getSize(); i++) {
            if (simpleArray.container[i].equals(model)) {
                return false;
            }
        }
        simpleArray.add(model);
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return simpleArray.iterator();
    }
}
