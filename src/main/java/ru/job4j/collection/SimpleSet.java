package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {
    SimpleArray<T> simpleArray = new SimpleArray<>();

    public boolean add(T model) {
        if (checkModel(model)) {
            simpleArray.add(model);
        }
        return false;
    }

    public boolean checkModel(T model) {
        for (int i = 0; i < simpleArray.getSize(); i++) {
            if (Objects.equals(simpleArray.getContainer()[i], model)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return simpleArray.iterator();
    }
}
