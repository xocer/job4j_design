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
        if (data[row].length == 0) {
            while (row != data.length - 1) {
                if (data[++row].length != 0) {
                    flag = true;
                }
            }
            return flag;
        }
        return row < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (column < data[row].length) {
            return data[row][column++];
        } else {
            row++;
            column = 0;
            while (data[row].length == 0) {
                row++;
            }
            return data[row][column++];
        }
    }

    @Override
    public void remove() {

    }
}