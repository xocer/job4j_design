package ru.job4j.io;

import java.io.FileInputStream;
import java.sql.SQLOutput;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("even.txt")) {
            int read;
            StringBuilder text = new StringBuilder();
            while ((read = fis.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String s : lines) {
                int i = Integer.parseInt(s);
                System.out.println("Число " + i + " является "
                        + (i % 2 == 0 ? "четныем" : "нечетным"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
