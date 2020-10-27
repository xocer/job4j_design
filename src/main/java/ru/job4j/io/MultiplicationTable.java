package ru.job4j.io;

import java.io.FileOutputStream;

public class MultiplicationTable {
    public static void main(String[] args) {
        MultiplicationTable multiplicationTable = new MultiplicationTable();
        multiplicationTable.writeInTableMultipl(10, 10);

    }

    public void writeInTableMultipl(int q, int a) {
        try (FileOutputStream fos = new FileOutputStream("result")) {
            for (int i = 1; i < q; i++) {
                for (int j = 1; j < a; j++) {
                    fos.write((i + " * " + j + " = " + i * j + "\n").getBytes());
                }
                fos.write("\n".getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
