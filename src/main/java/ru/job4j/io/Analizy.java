package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
                BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            List<String> list = new ArrayList<>();
            boolean flag = false;
            while (reader.ready()) {
                String tmp = reader.readLine();
                if (!tmp.isEmpty()) {
                    String[] s = tmp.split(" ");
                    if ((s[0].equals("200") || s[0].equals("300")) && flag) {
                        list.add(s[1] + System.lineSeparator());
                        flag = false;

                    } else if ((s[0].equals("400") || s[0].equals("500")) && !flag) {
                        list.add(s[1] + ";");
                        flag = true;
                    }
                }
            }
            for (String s : list) {
                writer.write(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Analizy analizy = new Analizy();
        analizy.unavailable("server.log", "unavailable.csv");
//        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
//            out.println("15:01:30;15:02:32");
//            out.println("15:10:30;23:12:32");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}