package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean flag = false;
        if (row >= data.length) {
            return false;
        }
        if (data[row].length != 0 && column < data[row].length) {
            flag = true;
        } else if (data[row].length == 0) {
            row++;
            return hasNext();
        } else if (column >= data[row].length) {
            column = 0;
            row++;
            return hasNext();
        }
        return flag;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }

}