package ru.job4j.kiss;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return get(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return get(value, comparator);
    }

    private <T> T get(List<T> value, Comparator<T> comparator) {
        T o1 = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            if (comparator.compare(value.get(i), o1) > 0) {
                o1 = value.get(i);
            }
        }
        return o1;
    }
}