//package ru.job4j.it;
//
//import java.util.Iterator;
//import java.util.NoSuchElementException;
//
//public class MatrixIt implements Iterator<Integer> {
//    private final int[][] data;
//    private int row = 0;
//    private int column = 0;
//
//    public MatrixIt(int[][] data) {
//        this.data = data;
//    }
//
//    @Override
//    public boolean hasNext() {
//        return row+column <= data.length;
//    }
//
//    @Override
//    public Integer next() {
//        if (!hasNext()) {
//            throw new NoSuchElementException();
//        }
//        if (column < data.length) {
//            return data[row][column++];
//        } else return data[++row][column = 0];
//    }
//
//    @Override
//    public void remove() {
//
//    }
//}