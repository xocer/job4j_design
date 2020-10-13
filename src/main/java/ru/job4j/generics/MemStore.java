package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int i = searchId(id);
        if (i != -1) {
            mem.set(i, model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int i = searchId(id);
        if (i != -1) {
            mem.remove(i);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        int i = searchId(id);
        if (i != -1) {
            return (T) mem.get(i);
        }
        return null;
    }

    public int searchId(String id) {
        int s = -1;
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                return i;
            }
        }
        return s;
    }
}