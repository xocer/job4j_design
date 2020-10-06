package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private int[] numbers;
    private int point = 0;

    public EvenNumbersIterator(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        if (numbers.length == 1) {
            return false;
        }
        if (point < numbers.length - 1) {
            return (numbers[point + 1] % 2 == 0);
        }
        return (numbers[point] % 2 == 0);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (numbers[point] % 2 != 0) {
            point++;
            return numbers[point++];
        } else {
            return numbers[point++];
        }

    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }


}
